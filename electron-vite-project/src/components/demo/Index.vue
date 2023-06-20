// demo/Index.vue
<template>
  <h1>
    欢迎使用武汉市地铁导引系统
  </h1>
  <el-button size="large" type="success" @click="goTo('/home')">进入</el-button>
</template>

<script setup lang="ts">

import{useRouter,useRoute}from 'vue-router'
const router=useRouter();

function goTo(path: string)
{
    router.push(path);
}


</script>

<style scoped>

</style>