Ext.define('LSYS.store.ComboboxStore', {
    extend: 'Ext.data.Store',
    model: 'LSYS.model.ComboboxModel',
    data: [
           { "state": "未呼通", "sname": "未呼通" },
           { "state": "未外呼", "sname": "未外呼" },
           { "state": "已呼通", "sname": "已呼通" },
           { "state": "已办理", "sname": "已办理" },
           { "state": "已拒听", "sname": "已拒听" }
       ]
});
