<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'

import dayjs from 'dayjs';
import utc from 'dayjs/plugin/utc';
import timezone from 'dayjs/plugin/timezone';

dayjs.extend(utc);
dayjs.extend(timezone);

const now = dayjs().tz('Asia/Seoul');

console.log(now);
console.log(now.format('YYYY년MM월DD일 HH시mm분ss초'));
console.log(now.format('YYYY-MM-DD HH:mm:ss'));

</script>

<template>
  <header>
    <h1>HELLO VUE</h1>
    <h1 class="text-5xl">{{ now.format('YYYY/MM/DD') }}</h1>
    <h1 class="text-5xl">{{ now.get('month') }}월</h1>
    <h1 class="text-5xl">{{ now.subtract(1,'month').format('YYYY/MM/DD') }}subtract</h1>
    <h1 class="text-5xl">{{ now.add(1,'month').format('YYYY/MM/DD') }}add</h1>

    <hr>
    <h1 class="text-3xl">첫 날 {{ now.startOf('month').format('YYYY-MM-DD') }}</h1>
    <h1 class="text-3xl">마지막 날 {{ now.endOf('month').format('YYYY-MM-DD') }}</h1>
  </header>
  <RouterView />
</template>

<style scoped>

</style>
