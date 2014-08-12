Ext.define('LSYS.store.MenuStore', {
    extend: 'Ext.data.TreeStore',
    proxy: {
                    type: 'ajax',
                    url: 'data/tree.json'
                }
    /*root: {
    	  id:'root',
    	  text:'root',
        children: [
            {   id:'ch',
                text: '201406',
                children: [
                    { id: 'array-grid', text: 'Array Grid', leaf: true },
                    { id: 'grouped-grid', text: 'Grouped Grid', leaf: true },
                    { id: 'locking-grid', text: 'Locking Grid', leaf: true },
                    { id: 'grouped-header-grid', text: 'Grouped Header Grid', leaf: true },
                    { id: 'multi-sort-grid', text: 'Multiple Sort Grid', leaf: true },
                    { id: 'progress-bar-pager', text: 'Progress Bar Pager', leaf: true },
                    { id: 'sliding-pager', text: 'Sliding Pager', leaf: true },
                    { id: 'reconfigure-grid', text: 'Reconfigure Grid', leaf: true },
                    { id: 'property-grid', text: 'Property Grid', leaf: true },
                    { id: 'cell-editing', text: 'Cell Editing', leaf: true },
                    { id: 'row-expander-grid', text: 'Row Expander', leaf: true },
                    { id: 'big-data-grid', text: 'Big Data', leaf: true }
                ]
            }
        ]
    }*/
});