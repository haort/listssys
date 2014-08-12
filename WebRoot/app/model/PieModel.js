Ext.define('LSYS.model.PieModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.reader.Json'
    ],
    fields: [
             {
                 name: 'name'
             },
             {
                 name: 'data1'
             }
         ]
});