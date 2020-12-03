/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Si', 'No'],
          ['Mucho',     11],
          ['Poco',      2]
        ]);

        var options = {
          title: 'Mis Datos',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }

