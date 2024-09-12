<template>
  <div>
    <h1>{{ myVar }}</h1>
    <TheHeader/>
  </div>
</template>

<script setup>
import {RouterLink, RouterView} from 'vue-router';
import TheHeader from './components/TheHeader.vue';
const myVar = "안녕하세요";
</script>

<style lang="scss" scoped></style>
