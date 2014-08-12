Ext.define('LSYS.store.Users', {
    extend: 'Ext.data.Store',
    model: 'LSYS.model.User',
    pageSize:2,
    autoLoad: true,
  /*  data:[
        {id: 1, name: 'a',    email: 'ed@sencha.com'},
        {id: 2, name: 'b', email: 'tommy@sencha.com'},
        {id: 3, name: 'c',    email: 'ed@sencha.com'},
        {id: 4, name: 'Tommy1', email: 'tommy@sencha.com'},
        {id: 5, name: 'Ed2',    email: 'ed@sencha.com'},
        {id: 6, name: 'Tommy2', email: 'tommy@sencha.com'},
        {id: 7, name: 'Ed3',    email: 'ed@sencha.com'},
        {id: 8, name: 'Tommy3', email: 'tommy@sencha.com'},
        {id: 9, name: 'Ed4',    email: 'ed@sencha.com'},
        {id: 0, name: 'Tommy5', email: 'tommy@sencha.com'}
        ]*/
    proxy: {
        type: 'ajax',
        api: {
            read: '/listssys/json/reportList.json',
            update: 'data/updateUsers.json'
        },
        reader: {
            type: 'json',
            root: 'users',
            successProperty: 'success'
        }
    }
});