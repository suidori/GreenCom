<template>
  <SideBar class="absolute"></SideBar>
  <h1 class="mx-60 py-4 text-blue-800 font-bold">마이페이지</h1>
  <hr class="w-2/3 mx-auto" />

  <div class="flex justify-center items-start p-6">
    <!-- 사진 영역 -->
    <aside>
      <img src="../images/stude.jpg" alt="#" class="w-40 flex" />
    </aside>

    <!-- 사용자 정보 영역 -->
    <div class="px-10 space-y-4 py-6">
      <!-- 이름 -->
      <div class="flex">
        <span class="font-bold text-gray-800 w-24">이름 </span>
        <span class="text-gray-500">김철수</span>
      </div>
      <!-- 전화번호 -->
      <div class="flex">
        <span class="font-bold text-gray-800 w-24">전화번호</span>
        <span class="text-gray-500">010-XXXX-XXXX</span>
      </div>
      <!-- 이메일 -->
      <div class="flex">
        <span class="font-bold text-gray-800 w-24">e-mail</span>
        <span class="text-gray-500">없음</span>
      </div>
    </div>
  </div>

  <hr class="border-2 border-b-blue-900 w-2/3 mx-auto" />
  <h1 class="mx-60 py-4 text-blue-800 font-bold">수강중인 강좌</h1>
  <div class="mx-60 flex flex-col justify-center items-center ">
    <div class="flex my-3">
      <h class="w-20 border text-center justify-center items-center flex bg-blue-900 text-white text-sm">강좌1</h>
      <input type="text" name="강의정보" id="" class="border mx-3 w-96 h-10 text-xs" placeholder=" 강의정보-강사:000 / 강의시간 0교시"/>
    </div>
    <div class="flex">
      <h class="w-20 border text-center justify-center items-center flex bg-blue-900 text-white text-sm">강좌2</h>
      <input type="text" name="강의정보" id="" class="border mx-3 w-96 h-10 text-xs" placeholder=" 강의정보-강사:000 / 강의시간 0교시"/>
    </div>
  </div>
</template>

<script setup>
import SideBar from '@/component/SideBar.vue'
</script>

<style lang="scss" scoped></style>
