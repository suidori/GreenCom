<template>
  <div class="pb-10">
    <h1 class="h1-red">FreeBoardList</h1>
    <div class="px-5">
      <table class="border border-b-gray-500 w-full">
        <thead>
          <tr>
            <th class="border">IDX</th>
            <th class="border">title</th>
            <th class="border">author</th>
            <th class="border">regdate</th>
            <th class="border">viewcount</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in arr"
            :key="item.f_idx"
            class="cursor-pointer hover:bg-slate-300"
            @click="viewPage(item.idx)"
          >
            <td class="border text-center text-lg p-1">{{ item.f_idx }}</td>
            <td class="border text-center text-lg p-1">{{ item.f_title }}</td>
            <td class="border text-center text-lg p-1">{{ item.f_nickname }}</td>
            <td class="border text-center text-lg p-1">{{ item.ftimestamp }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="flex justify-center mt-5">
      <ul class="flex space-x-5">
        <li
          class="cursor-pointer p-3"
          v-for="num in totalPages"
          v-bind:key="num"
          @click="getFreeBoard(num - 1)"
        >
          {{ num }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const route = useRouter()
const arr = ref([])
const totalPages = ref('')

const viewPage = (idx) => {
  const data = { name: 'freeboardview', params: { idx } }
  route.push(data);
}

const getFreeBoard = (pageNum) => {
  if (pageNum == undefined) {
    pageNum = 0
  }
  axios
    .get(`http://localhost:8080/freeboard/select?pageNum=${pageNum}`)
    .then((res) => {
      console.log(res.data)
      arr.value = res.data.list
      totalPages.value = res.data.totalPages
    })
    .catch((e) => {
      console.log(e)
    })
}

getFreeBoard()
</script>

<style scoped></style>
