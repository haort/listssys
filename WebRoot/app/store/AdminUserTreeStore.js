Ext.define('LSYS.store.AdminUserTreeStore', {
	extend : 'Ext.data.TreeStore',
	model:'LSYS.model.AdminUserTreeModel',
    proxy: {
        type: 'ajax',
        url: '/listssys/service/getAdminUser.json'
    },
    root: {
        expanded: true
    },
    folderSort: true,
    sorters: [{
        property: 'text',
        direction: 'ASC'
    }]
});