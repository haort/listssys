Ext.define('LSYS.view.Navigation', {
	extend : 'Ext.tree.Panel',
	alias : 'widget.navigation',
	rootVisible : false,
	lines : false,
	useArrows : true,
	store : 'LSYS.store.MenuStore'
});