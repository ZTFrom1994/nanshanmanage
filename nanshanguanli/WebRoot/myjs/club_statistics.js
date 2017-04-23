$(function(){
//	var myChart = echarts.init(document.getElementById('main1'));
//    myChart.showLoading({text: "图表数据正在努力加载..."});
// 
//    $.ajax({
//    	url: "statisticsAction!getChartJson",
//    	dataType:"json",
//        success: function (data) { 
//		    	// 初始 option
//    	option = {
//    		    backgroundColor: '#2c343c',
//    		    title: {
//    		        text: '社团类别',
//    		        left: 'center',
//    		        top: 20,
//    		        textStyle: {
//    		            color: '#ccc'
//    		        }
//    		    },
//
//    		    tooltip : {
//    		        trigger: 'item',
//    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
//    		    },
//
//    		    visualMap: {
//    		        show: false,
//    		        min: 80,
//    		        max: 600,
//    		        inRange: {
//    		            colorLightness: [0, 1]
//    		        }
//    		    },
//    		    series : [
//    		        {
//    		            name:'社团类别', 
//    		            type:'pie',
//    		            radius : '55%',
//    		            center: ['50%', '50%'],
//    		            data:[
//    		                {value:28, name:'公益类'},
//    		                {value:31, name:'娱乐类'},
//    		                {value:44, name:'学术类'}, 
//    		                {value:21, name:'技术类'},
//    		                {value:40, name:'体育类'}
//    		            ].sort(function (a, b) { return a.value - b.value}),
//    		            roseType: 'angle',
//    		            label: {
//    		                normal: {
//    		                    textStyle: {
//    		                        color: 'rgba(255, 255, 255, 0.3)'
//    		                    }
//    		                }
//    		            },
//    		            labelLine: {
//    		                normal: {
//    		                    lineStyle: {
//    		                        color: 'rgba(255, 255, 255, 0.3)'
//    		                    },
//    		                    smooth: 0.2,
//    		                    length: 10,
//    		                    length2: 20
//    		                }
//    		            },
//    		            itemStyle: {
//    		                normal: {
//    		                    color: '#c23531',
//    		                    shadowBlur: 200,
//    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
//    		                }
//    		            }
//    		        }
//    		    ]
//    			};
//                myChart.hideLoading();
//                myChart.setOption(option);
//        },
//        error: function (errorMsg) {
//            alert("图表请求数据失败啦!");
//        }
//    });
    
    var myChart = echarts.init(document.getElementById('main'));
    myChart.showLoading({text: "图表数据正在努力加载..."});
   
    
    myChart.title = '活动层叠柱状图';
    option = {
    		 title: {
    		text: '活动层叠柱状图',
    		left: 'center',
    		top: 0,
    		textStyle: {
            color: '#000000'
        }
    	},
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
       
        legend: {
            data:['比赛类','实践类','讲座类','表演类','展览类','纳新类','娱乐类','研究类','其他'],
            top:30  
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : ['周一','周二','周三','周四','周五','周六','周日']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'比赛类',
                type:'bar',
                data:[3, 3, 2, 3, 3, 4, 3]
            },
            {
                name:'实践类',
                type:'bar',
                stack: '广告',
                data:[1, 1, 1, 1, 0, 2, 2]
            },
            {
                name:'讲座类',
                type:'bar',
                stack: '广告',
                data:[2, 1, 1, 2, 2, 3, 3]
            },
            {
                name:'表演类',
                type:'bar',
                stack: '广告',
                data:[1, 2, 1, 1, 1, 3, 4]
            },
            {
                name:'展览类',
                type:'bar',
                data:[8, 10, 9, 10, 6, 10, 7],
                markLine : {
                    lineStyle: {
                        normal: {
                            type: 'dashed'
                        }
                    },
                    data : [
                        [{type : 'min'}, {type : 'max'}]
                    ]
                }
            },
            {
                name:'纳新类',
                type:'bar',
                barWidth : 5,
                stack: '搜索引擎',
                data:[0, 0, 0, 0, 0, 0, 20]
            },
            {
                name:'娱乐类',
                type:'bar',
                stack: '搜索引擎',
                data:[1, 1, 1, 1, 2,0, 2]
            },
            {
                name:'研究类',
                type:'bar',
                stack: '搜索引擎',
                data:[6, 7, 7, 7, 1, 13, 11]
            },
            {
                name:'其他',
                type:'bar',
                stack: '搜索引擎',
                data:[6, 8, 9, 4, 7, 0, 0]
            }
        ]
    };
    myChart.hideLoading();
    myChart.setOption(option);
    
})