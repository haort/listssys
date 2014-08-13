Ext.define('LSYS.controller.Users', {
    extend: 'Ext.app.Controller',

    stores: [
        'Users@LSYS.store',
        'LSYS.store.MenuStore',
        'LSYS.store.PieStore'    ],

    models: [
        'User@LSYS.model',
        'LSYS.model.MenuModel',
        'LSYS.model.PieModel'
    ],

    views: [
        'Edit@LSYS.view.user',
        'List@LSYS.view.user',
        'LSYS.view.Navigation',
        'LSYS.view.Pie'   ],

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
    ],

    init: function() {
        this.control({
            'userlist': {
                itemdblclick: this.editUser
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
           }
            
        });
    },

    editUser: function(grid, record) {
        var edit = Ext.create('LSYS.view.user.Edit').show();
        edit.down('form').loadRecord(record);
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
    	var params = {record:rec.get("text")};  
    	var isLeaf = rec.get("leaf");
    	if(isLeaf){
    		var gridStore = this.getUserlist().getStore();
        	gridStore.setProxy({
                type: 'ajax',
                api: {
                    read: '/listssys/json/reportList.json',
                    update: 'data/updateUsers.json'
                },
                reader: {
                    type: 'json',
                    root: 'users',
                    totalProperty: 'totalCount',
                    successProperty: 'success'
                }
            });
    		Ext.apply(gridStore.proxy.extraParams, params);  
    		gridStore.load();
    	}
    }
    
});
