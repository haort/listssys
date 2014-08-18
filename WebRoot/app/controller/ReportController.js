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
        'LSYS.view.report.Edit',
        'LSYS.view.report.List',
        'LSYS.view.Navigation',
        'LSYS.view.Pie',
        'LSYS.view.ComboboxView'],

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
    	table = rec.get("id");
    	var isLeaf = rec.get("leaf");
    	if(isLeaf){
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
    	}
    },
    logout:function(){
    	 window.location = "/listssys/loginout";
    }
    
});

