Ext.define('LSYS.store.AdminGridStore', {
    extend: 'Ext.data.Store',
    model: 'LSYS.model.ReportModel',
    pageSize:20,
    proxy:{
        type: 'ajax',
        api: {
            read: '/listssys/service/adminReportList.json'
        },
        reader: {
            type: 'json',
            totalProperty: 'totalCount',
            successProperty: 'success',
            root: 'users'
        }
    }
});