Ext.define('LSYS.view.admin.AdminTree', {
    extend: 'Ext.window.Window',
    alias : 'widget.admintree',
    layout: 'fit',
    autoShow: true,
    width: 800,
    height:500,
    modal : true,
    items:[{
    	 xtype: 'treepanel',
    	 rootVisible : false,
    		lines : false,
    		useArrows : true,
    		store : 'LSYS.store.AdminTreeStore',
    		bbar : [ {
    			text : '确定',
    			id : 'adminOkBtn'
    		} , {
    			text : '取消',
    			id : 'adminCancelBtn'
    		} ]
    }]
});
