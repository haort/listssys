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
                field: 'data1',
                showInLegend: true,
                donut: false,
                tips: {
                  trackMouse: true,
                  width: 100,
                  height: 28,
                  renderer: function(storeItem, item) {
                    //calculate percentage.
                    var total = 0;
                   Ext.getCmp('piechart').store.each(function(rec) {
                        total += rec.get('data1');
                    });
                    this.setTitle(storeItem.get('name') + ': ' + Math.round(storeItem.get('data1') / total * 100) + '%');
                  }
                },
                highlight: {
                  segment: {
                    margin: 20
                  }
                },
                label: {
                    field: 'name',
                    display: 'rotate',
                    contrast: true,
                    font: '10px 黑体'
                }
            }]
        });


   
