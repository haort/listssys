Ext.define('LSYS.view.Navigation', {
	extend : 'Ext.tree.Panel',
	alias : 'widget.navigation',
	rootVisible : false,
	lines : false,
	useArrows : true,
	store : 'LSYS.store.MenuStore',
	tbar : [ {
		text : '退出系统',
		id : 'logoutbtn'
	} ]
});