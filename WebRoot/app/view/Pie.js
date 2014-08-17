Ext.define('LSYS.view.Pie', {
           extend: 'Ext.chart.Chart',
           animate: true,
           alias : 'widget.listpie',
            store:'LSYS.store.PieStore',
            id: 'piechart',
            shadow: true,
            legend: {
                position: 'right'
            },
            theme: 'Base:gradients',
            series: [{
                type: 'pie',
                field: 'count',
                showInLegend: true,
                tips: {
                  trackMouse: true,
                  width: 100,
                  height: 28,
                  renderer: function(storeItem, item) {
                    //calculate percentage.
                    var total = 0;
                   Ext.getCmp('piechart').store.each(function(rec) {
                        total += rec.get('count');
                    });
                    this.setTitle(storeItem.get('state') + ': ' + Math.round(storeItem.get('count') / total * 100) + '%');
                  }
                },
                highlight: {
                  segment: {
                    margin: 20
                  }
                },
                label: {
                    field: 'state',
                    display: 'rotate',
                    contrast: true,
                    font: '10px 黑体'
                }
            }]
        });


   
