<template>
  <div class="p-10">
    <h1 class="text-5xl">HOME</h1>
    <p>ref 반응형 함수를 사용해 봅시다</p>
    <h2>{{ count }}</h2>
    <div class="flex space-x-3">
      <button
        class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded"
        @click="doPlus"
      >
        증가
      </button>
      <button
        class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded"
        @click="doMinus"
      >
        감소
      </button>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
export default {
  setup() {
    const count = ref(0)
    const doPlus = () => {
      count.value = count.value + 1
    }
    const doMinus = () => {
      count.value = count.value - 1
    }
    return { count, doPlus, doMinus }
  }
}
</script>

<style lang="scss" scoped></style>
