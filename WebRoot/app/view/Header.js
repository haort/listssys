Ext.define('LSYS.view.Header', {
    extend: 'Ext.Container',
    xtype: 'appHeader',
    id: 'app-header',
    height: 52,
    layout: {
        type: 'hbox',
        align: 'middle'
    },
    initComponent: function() {
        this.items = [{
            xtype: 'component',
            id: 'app-header-title',
            html: '六合电信派单管理系统',
            flex: 1
        },{ margin: '0 10 0 0',
            xtype: 'button',
            text:'退出系统',
            id : 'logoutbtn',
            width: 80
        }];

        this.callParent();
    }
});
