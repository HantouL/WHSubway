<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <div>
          <h3>请输入出发站点</h3>
          <el-tooltip class="box-item" effect="dark" content="可以直接输入站名哦~" placement="left-start">

            <el-select v-model="startStation" filterable placeholder="Select">
              <el-option v-for="station in stations" :key="station.id" :label="station.name" :value="station.name" />
            </el-select>
          </el-tooltip>


          <h3>请输入目的站点</h3>
          <el-select v-model="endStation" filterable placeholder="Select">
            <el-option v-for="station in stations" :key="station.id" :label="station.name" :value="station.name" />
          </el-select>

          <h3>
            <el-button type="success" plain @click="submit()">出发!</el-button>
          </h3>
        </div>

        <div class="weather-widget" width="800">
          <p>武汉当前实时天气：</p>
          <p>天气：{{ weather?.text }}</p>
          <p  @click="task()">温度：{{ weather?.temp }}℃</p>
        </div>
      </el-aside>
          <el-main>
              <HelloWorld></HelloWorld>
          </el-main>
      </el-container>
    </div>
</template>
  
<script lang="ts">
import axios from 'axios'
import HelloWorld from "HelloWorld.vue"
import { h } from 'vue'
import { ElNotification } from 'element-plus'


interface Station {
  name: string;
  id: number;
  // 其他属性
}

interface Weather {
  temp: string;
  icon: string;
  text: string;
}

export default {

  data() {
    return {
      stations: [] as Station[],
      startStation: '',
      endStation: '',
      result: [] as String[],
      weather: null as Weather | null,
      names: ''
    }
  },
  created() {
    axios.get<{ data: Station[] }>
      ('http://localhost:8081/subway/stations/getStations').then((response) => {
        this.stations = response.data.data
        this.startStation = ''
        this.endStation = ''
      })
  },
  mounted() {
    console.log('mounted!')
    this.getWeather();
  },
  methods: {
    submit() {
      if (!this.startStation || !this.endStation) {
        alert("请输入出发和目的站点")
        return;
      }
      axios.get('http://localhost:8081/subway/way/findWay', {
        params: {
          startStation: this.startStation,
          endStation: this.endStation
        }
      })
        .then(response => {
          this.result = response.data.data as String[];
          this.show();
        })
        .catch(error => {
          console.log(error);
        });
    },
    show() {
      let count = this.result.length;
      this.result.forEach((station, index) => {
        if (index !== 0) {
          this.names += ' -> ';
        }
        this.names += station;
      });
      confirm(`路径：${this.names}，共${count - 1}站`);
      open();
    },
    getWeather() {
      axios.get("https://devapi.qweather.com/v7/weather/now?location=101200101&key=c60718558c3746299ba1d83bd38d3b38")
        .then((response) => {
          const weatherData = response.data.now;
          this.weather = {
            temp: weatherData.temp,
            icon: weatherData.icon,
            text: weatherData.text
          };
        })
        .catch(error => {
          console.log(error);
        });
    },
    task(){
    alert("软件课设要求:\n1.具有图形菜单界面；\n2.用户输入起点站和目标站，系统向用户显示一条最短路径（经过站数最少的路线），如果有两条以上最短路线，则按换乘次数排序显示;\n3.显示每一条路线时，不仅要显示应搭乘的车次，还要显示应搭乘站的站名。")
  },
  },

}

</script>

<style scoped>
.weather-widget {
  position: fixed;
  bottom: 20px;
  left: 20px;
}
</style>
