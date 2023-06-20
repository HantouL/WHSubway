// src\router\index.ts

import { createRouter, createWebHashHistory } from 'vue-router'
import Demo from '..\components\demo\Index.vue'

const router = createRouter({
  //  hash 模式。
  history: createWebHashHistory(),
  routes: [
    // 设置首页
    {
      path: '/',
      component: () => import('../components/demo/Index.vue')
    },
    // 配置HOME页的路径
    { 
        path: '/home', 
        component: () => import('../components/demo/home.vue') 
      },
  ],
})

export default router
