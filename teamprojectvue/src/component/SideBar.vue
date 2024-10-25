<template>
  <div class="w-36 bg-blue-900">
    <aside class="text-white p-4">
      <h2 class="text-lg font-bold mb-6 h-20">메뉴</h2>
      <ul class="space-y-3">
        <hr />
        <RouterLink to="/attendancecheck">
          <li><a href="#" class="block text-sm pt-3">출결 관리</a></li>
        </RouterLink>
        <hr />
        <li><a href="#" class="block text-sm">문의 게시판</a></li>
        <hr />
        <RouterLink to="/vacationform">
          <li><a href="#" class="block text-sm pt-3">휴가 신청서 제출</a></li>
        </RouterLink>
        <hr />
        <RouterLink to="/lectureselect">
          <li><a href="#" class="block text-sm pt-3">과정 선택</a></li>
        </RouterLink>
        <hr />
        <RouterLink to="/mypage">
          <li><a href="#" class="block text-sm pt-3">마이페이지</a></li>
        </RouterLink>
        <hr />
        <li><a href="#" class="block text-sm">공지 사항</a></li>
      </ul>
      <div class="mt-20 text-xs">
        <p>주소 : 대구광역시 교육 지원센터 OO</p>
        <p>전화 : 000-0000-000</p>
        <p>FAX : 000-0000-000</p>
      </div>
    </aside>
  </div>
</template>

<script setup></script>

<style lang="scss" scoped></style>
