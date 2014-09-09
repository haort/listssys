Ext.define('LSYS.view.report.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
    title : '清单',
    store: 'LSYS.store.ReportStore',
    columns: [
        {header: '状态',  dataIndex: 'state',  flex: 1,editor : {
             	 xtype : 'coboview',
             	 }},
             	{header: '备注',  dataIndex: 'remark',  flex: 1,editor : {
                 	 xtype : 'textfield',
                 	 }},
                 {header: '更新时间'  ,dataIndex: 'formatDate'  ,flex: 1},
                 {header: '姓名'  ,dataIndex: 'servName'  ,flex: 1},
                 {header: '地址'  ,dataIndex: 'servAddr'  ,flex: 1,hidden: true},
                 {header: '宽带号'  ,dataIndex: 'accsNbr'  ,flex: 1},
                 {header: '固定电话'  ,dataIndex: 'telephone'  ,flex: 1},
                 {header: '套餐'  ,dataIndex: 'ty'  ,flex: 1},
                 {header: '速率'  ,dataIndex: 'speed'  ,flex: 0.5},
                 {header: '起始日期'  ,dataIndex: 'startdt'  ,flex: 1,hidden: true},
                 {header: '联系号码'  ,dataIndex: 'prodTel'  ,flex: 1},
                 {header: '宽带在线天数'  ,dataIndex: 'bipDataNum'  ,flex: 1,hidden: true},
                 {header: '宽带在线时长'  ,dataIndex: 'bipDuration'  ,flex: 1,hidden: true},
                 {header: '区域'  ,dataIndex: 'area'  ,flex: 1},
                 {header: '接入方式'  ,dataIndex: 'rsrc'  ,flex: 1},
                 {header: '套餐'  ,dataIndex: 'packName'  ,flex: 1},
                 {header: '手机'  ,dataIndex: 'phone'  ,flex: 1},
                 {header: '加装业务'  ,dataIndex: 'wareName'  ,flex: 1,hidden: true},
                 {header: '网格名称'  ,dataIndex: 'gridName'  ,flex: 1,hidden: true},
                 {header: '营业厅名称'  ,dataIndex: 'chName'  ,flex: 1,hidden: true}],
    bbar:[
    {xtype:'pagingtoolbar',store:'LSYS.store.ReportStore'}
    ],
    selModel: {
        selType: 'cellmodel'
    },
    plugins: [Ext.create('Ext.grid.plugin.RowEditing',{clicksToEdit: 1,saveBtnText: '保存',cancelBtnText: "取消"})]
});
