var table;
Ext.define('LSYS.controller.Users', {
    extend: 'Ext.app.Controller',

    stores: [
        'Users@LSYS.store',
        'LSYS.store.MenuStore',
        'LSYS.store.PieStore',
        'LSYS.store.ComboboxStore'],

    models: [
        'User@LSYS.model',
        'LSYS.model.MenuModel',
        'LSYS.model.PieModel',
        'LSYS.model.ComboboxModel'
    ],

    views: [
        'Edit@LSYS.view.user',
        'List@LSYS.view.user',
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
            '#savePie': {
            	 click: this.savePie
            },
            '#reData': {
            	 click: this.refreshData
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
                update: '/listssys/json/updateState.json'
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
                read: '/listssys/json/reportList.json',
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
    savePie:function(){
    	 Ext.MessageBox.confirm('是否下载', '是否将图标保存为图片?', function(choice){
             if(choice == 'yes'){
            	 var listpie = Ext.getCmp('piechart');
            	 listpie.save({
                     type: 'image/png'
                 });
             }
         });
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
                    read: '/listssys/json/reportList.json',
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
    		pieStore.load();
    	}
    }

    
});

