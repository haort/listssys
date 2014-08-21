Ext.define('LSYS.view.admin.AdminGrid' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.adminlist',
    title : '分配清单',
    store: 'LSYS.store.ReportStore',
    columns: [
        {header: '状态',  dataIndex: 'state',  flex: 1},
        {header: '姓名',  dataIndex: 'name',  flex: 1},
        {header: '地址', dataIndex: 'addr', flex: 1},
        {header: '手机', dataIndex: 'phone', flex: 1},
        {header: '接入号', dataIndex: 'acc', flex: 1},
        {header: '支局', dataIndex: 'area', flex: 1},
        {header: '起始日期', dataIndex: 'startdt', flex: 1},
        {header: '截止日期', dataIndex: 'enddt', flex: 1}
    ],
    selType: 'checkboxmodel',
    bbar:[
    {xtype:'pagingtoolbar',store:'LSYS.store.ReportStore'}
    ],
    tbar: [{
        text: '分配',
        id:'sendList'
    }]
});
