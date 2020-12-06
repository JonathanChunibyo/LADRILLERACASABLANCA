/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var data = google.visualization.arrayToDataTable([
        ['Year', 'Datos', 'Mas Datos'],
        ['2004', 1000, 400],
        ['2005', 1170, 460],
        ['2006', 660, 1120],
        ['2007', 1030, 540]
    ]);

    var options = {
        title: 'Consumo',
        curveType: 'function',
        legend: {position: 'bottom'}
    };

    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

    chart.draw(data, options);
}

google.charts.load('current', {'packages': ['line']});
google.charts.setOnLoadCallback(drawChart2);

function drawChart2() {

    var data = new google.visualization.DataTable();
    data.addColumn('number', 'Hora');
    data.addColumn('number', 'Consumo');
    data.addRows([
        [1, 37.8],
        [2, 30.9],
        [3, 25.4],
        [4, 11.7],
    ]);

    var options = {
        width: 800,
        height: 250
    };

    var chart = new google.charts.Line(document.getElementById('curve_chart'));

    chart.draw(data, google.charts.Line.convertOptions(options));
}