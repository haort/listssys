﻿Ext.define('LSYS.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
    title : '清单',
    store: 'Users',
    columns: [
        {header: '姓名',  dataIndex: 'name',  flex: 1},
        {header: '电子邮件', dataIndex: 'email', flex: 1},
        {
            menuDisabled: true,
            sortable: false,
            xtype: 'actioncolumn',
            width: 50,
            items: [{
                icon   : '../../listssys/extjs/resources/ext-theme-neptune/images/shared/icon-info.png',  // Use a URL in the icon config
                tooltip: 'Sell stock',
                handler: function(grid, rowIndex, colIndex) {
                    var rec = getStore().getAt(rowIndex);
                    alert("Sell " + rec.get('company'));
                }
            }, {
                getClass: function(v, meta, rec) {          // Or return a class from a function
                    if (rec.get('change') < 0) {
                        return 'alert-col';
                    } else {
                        return 'buy-col';
                    }
                },
                getTip: function(v, meta, rec) {
                    if (rec.get('change') < 0) {
                        return 'Hold stock';
                    } else {
                        return 'Buy stock';
                    }
                },
                handler: function(grid, rowIndex, colIndex) {
                    var rec = store.getAt(rowIndex);
                    alert((rec.get('change') < 0 ? "Hold " : "Buy ") + rec.get('company'));
                }
            }]
        }
    ],
    bbar:[
    {xtype:'pagingtoolbar',store:'Users'}
    ]
});
