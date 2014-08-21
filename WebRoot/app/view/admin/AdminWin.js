Ext.define('LSYS.view.admin.AdminWin', {
    extend: 'Ext.window.Window',
    alias : 'widget.adminwin',
    layout: 'fit',
    autoShow: true,
    width: 800,
    height:500,
    modal : true,
    items:[{
    	 xtype: 'adminlist'
    }]
});
