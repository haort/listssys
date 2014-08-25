var table;
Ext.define('LSYS.controller.ReportController', {
    extend: 'Ext.app.Controller',

    stores: [
        'LSYS.store.ReportStore',
        'LSYS.store.MenuStore',
        'LSYS.store.PieStore',
        'LSYS.store.ComboboxStore',
        'LSYS.store.AdminTreeStore',
        'LSYS.store.AdminGridStore'],

    models: [
        'LSYS.model.ReportModel',
        'LSYS.model.MenuModel',
        'LSYS.model.PieModel',
        'LSYS.model.ComboboxModel',
        'LSYS.model.AdminTreeModel'
    ],

    views: [
        'LSYS.view.admin.AdminWin',
        'LSYS.view.admin.AdminTree',
        'LSYS.view.report.List',
        'LSYS.view.Navigation',
        'LSYS.view.Pie',
        'LSYS.view.ComboboxView',
        'LSYS.view.DescriptionPanel',
        'LSYS.view.admin.AdminGrid'],

    refs: [
        {
            ref: 'usersPanel',
            selector: 'panel'
        },
        {
            ref: 'userlist',
            selector: 'userlist'
        }
        ,
        {
            ref: 'navigation',
            selector: 'navigation'
        }
        ,
        {
            ref: 'listpie',
            selector: 'listpie'
        }
        ,
        {
            ref: 'coboview',
            selector: 'coboview'
        },
        {
            ref: 'despanel',
            selector: 'despanel'
        },
        {
            ref: 'adminlist',
            selector: 'adminlist'
        },
        {
            ref: 'admintree',
            selector: 'admintree'
        }
    ],

    init: function() {
        this.control({
            'userlist': {
        	    edit: this.editUser
            },
            'useredit button[action=save]': {
                 click: this.updateUser
            },
            '#reData': {
            	 click: this.refreshData
            },
            '#logoutbtn': {
           	     click: this.logout
           },
            'navigation': {
            	itemclick: this.changePage
           },
            'coboview': {
            	itemclick: this.changePage
           },
           '#sendList':{
        	   click:this.sendListShow
           }
           ,
           '#adminOkBtn':{
        	   click:this.sendList
           }
           ,
           '#adminCancelBtn':{
        	   click:this.sendListCancel
           }
        });
    },

    editUser: function(editor, e) {
    	var gridStore = e.grid.getStore();
    	gridStore.setProxy({
            type: 'ajax',
            api: {
                update: '/listssys/service/updateState.json'
            },
            reader: {
                successProperty: 'success'
            },
            extraParams:{data:e.record.data,table:table}
        });
		gridStore.sync({
			success: function (op){
			e.record.commit();
		}}); 
		gridStore.setProxy({
            type: 'ajax',
            api: {
                read: '/listssys/service/reportList.json'
            },
            reader: {
                type: 'json',
                root: 'users',
                totalProperty: 'totalCount',
                successProperty: 'success'
            },
            extraParams:{table:table}
        });
	},

    updateUser: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        record.set(values);
        win.close();
        this.getUsersStore().sync();
    },
    refreshData:function(){
    	 this.getListpie().getStore().reload();
    }
    ,
    changePage:function(view, rec, item, index, e){
    	var isLeaf = rec.get("leaf");
    	if(isLeaf){
    		table = rec.get("id");
    		//加载grid
    		var gridStore = this.getUserlist().getStore();
        	gridStore.setProxy({
                type: 'ajax',
                api: {
                    read: '/listssys/service/reportList.json'
                },
                reader: {
                    type: 'json',
                    root: 'users',
                    totalProperty: 'totalCount',
                    successProperty: 'success'
                },
                extraParams:{table:table}
            });
    		gridStore.load();
    		//加载pie
    		var pieStore = this.getListpie().getStore();
    		pieStore.setProxy ({
    			type : 'ajax',
    			url : '/listssys/service/getPie.json',
    			reader: {
    	            type: 'json'
    	        },
                extraParams:{table:table}
    		});
    		pieStore.load();
    		//加载描述
    		this.getDespanel().update(rec.get("description"));;
    		
    	}else{
    		var action  =  rec.get("id");
    		if(action=="ACTION_SEND"){
    			 var edit = Ext.create('LSYS.view.admin.AdminWin')
    			 var adminList = this.getAdminlist();
    			 var store = adminList.getStore();
    			 Ext.apply(store.proxy.extraParams,{table:table});
    			 store.load();
    			 edit.show();
    			 
    		}
    	}
    },
    logout:function(){
    	 Ext.Msg.confirm("请确认", "是否真的要退出？", function(button, text) { 
             if (button == "yes") { 
            	 window.location = "/listssys/loginout";
             }
    	 });
    	 
    },
    sendListShow:function(){
    	var adminList = this.getAdminlist();
    	var records = adminList.getSelectionModel().getSelection();
    	if(records.length>0){
    		 var edit = Ext.create('LSYS.view.admin.AdminTree').show();
    	}else{
        	 Ext.Msg.alert("提示", "请选中至少一条记录指派");
        }
    	
    	 
    }
    ,
    sendList:function(button){
        var adminTree =  this.getAdmintree().down('treepanel');
        var treeNode = adminTree.getSelectionModel().getLastSelected();
        if(treeNode!=null){
        	var adminList = this.getAdminlist();
        	var records = adminList.getSelectionModel().getSelection();
        	var store = adminList.getStore();
        	var recordids = [];
        	Ext.each(records,function(record){
        		recordids.push(record.get("id"));
        	});
        	Ext.Ajax.request({
                url: '/listssys/service/updateOwner.json',
                params: {recordids: recordids, userid: treeNode.get("id"),table:table },
                method: 'Post',
                success: function (response, options) {
                    Ext.MessageBox.alert('成功', '分配成功！');
                	store.remove(records);
                    store.load();
                    button.up('window').close();
                },
                failure: function (response, options) {
                    Ext.MessageBox.alert('失败', '请求超时或网络故障,错误编号：' + response.status);
                }
            });
        }else{
        	Ext.Msg.alert("提示", "请选择一个指派对象");
        }
        	
    },
    sendListCancel:function(button){
    	var win = button.up('window');
    	win.close();
    }
    
});

