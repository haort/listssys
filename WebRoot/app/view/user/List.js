Ext.define('LSYS.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
    title : '清单',
    store: 'Users',
    columns: [
        {header: '状态',  dataIndex: 'state',  flex: 1,editor : {
             	 xtype : 'coboview',
             	 }},
        {header: '姓名',  dataIndex: 'name',  flex: 1},
        {header: '地址', dataIndex: 'addr', flex: 1},
        {header: '手机', dataIndex: 'phone', flex: 1},
        {header: '接入号', dataIndex: 'acc', flex: 1},
        {header: '支局', dataIndex: 'area', flex: 1},
        {header: '起始日期', dataIndex: 'startdt', flex: 1},
        {header: '截止日期', dataIndex: 'enddt', flex: 1}
    ],
    bbar:[
    {xtype:'pagingtoolbar',store:'Users'}
    ],
    selModel: {
        selType: 'cellmodel'
    },
    plugins: [Ext.create('Ext.grid.plugin.RowEditing', {clicksToEdit: 1})]
});
