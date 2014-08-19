Ext.define('LSYS.store.MenuStore', {
	extend : 'Ext.data.TreeStore',
	proxy : {
		type : 'ajax',
		url : '/listssys/service/getTreeListByList.json'
	},
    root: {
        expanded: true
    }
});