var table;
Ext.define('LSYS.controller.ReportController', {
    extend: 'Ext.app.Controller',

    stores: [
        'LSYS.store.ReportStore',
        'LSYS.store.MenuStore',
        'LSYS.store.PieStore',
        'LSYS.store.ComboboxStore'],

    models: [
        'LSYS.model.ReportModel',
        'LSYS.model.MenuModel',
        'LSYS.model.PieModel',
        'LSYS.model.ComboboxModel'
    ],

    views: [
        'LSYS.view.report.AdminWin',
        'LSYS.view.report.List',
        'LSYS.view.Navigation',
        'LSYS.view.Pie',
        'LSYS.view.ComboboxView',
        'LSYS.view.DescriptionPanel',
        'LSYS.view.AdminGrid'],

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
                read: '/listssys/service/reportList.json',
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
                    read: '/listssys/service/reportList.json',
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
    			 var edit = Ext.create('LSYS.view.report.AdminWin').show();
    		}
    	}
    },
    logout:function(){
    	 Ext.Msg.confirm("请确认", "是否真的要退出？", function(button, text) { 
             if (button == "yes") { 
            	 window.location = "/listssys/loginout";
             }
    	 });
    	 
    }
    
});
