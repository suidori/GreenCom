<template>
    <div id="container" class="flex">
        <div id="leftmenu" class="p-4 border border-blue-500 w-36">
            <h1>메뉴</h1>
            <RouterLink to="/join">
                <h1>회원가입</h1>
            </RouterLink>
            <RouterLink to="/loginview">
                <h1>로그인</h1>
            </RouterLink>
        </div>
        <div id="main">
            <div id="user">
                <h1>비로그인용 출결 관리</h1>
                <p>이름 <input type="text" placeholder="입력해주세요" class="border border-gray-500" v-model="name"></p>
                <p>전화번호 <label for="items"> </label>
                    <select id="items" name="items" class="border border-gray-500" v-model="phoneNumberfirst">
                        <option value="010" selected>010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="018">018</option>
                        <option value="019">019</option>
                    </select>
                    - <input type="text" v-model="phoneNumbersecond" class="border border-gray-500">
                    - <input type="text" v-model="phoneNumberthird" class="border border-gray-500">
                </p>
            </div>
            <div id="attendance">
                <h1>출결 변동 확인</h1>
                <p>1. 해당하는 출결 변동 사항을 선택 해 주세요.</p>
                <p>
                    <input type="radio" value="지각" name="attendance" v-model="type">지각
                    <input type="radio" value="조퇴" name="attendance" v-model="type">조퇴
                    <input type="radio" value="외출" name="attendance" v-model="type">외출
                    <input type="radio" value="결석" name="attendance" v-model="type">결석
                </p>
                <p>2. 출결에 변동이 생기는 일자를 골라주세요
                    <input type="date" name="dateInput" class="border border-gray-500" v-model="adate"></p>
                <p>3. 출결 변동의 원인을 적어주세요.</p>
                <p><input type="text" placeholder="예시) 병원, 예비군 등" class="border border-gray-500" v-model="reason"></p>
            </div>
            <button
            @click="guestattendance"
            class="px-4 py-2 font-bold text-white bg-blue-500 rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline"
            type="button"
            >
            제출하기
            </button>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const name = ref('');
const phoneNumberfirst = ref('');
const phoneNumbersecond = ref('');
const phoneNumberthird = ref('');
const adate = ref('');
const type = ref('');
const reason = ref('');

const guestattendance = async () => {
    const data = {
        "type": type.value,
        "reason": reason.value,
        "adate": adate.value,
        "user": {
            "name": name.value,
            "phoneNumber": `${phoneNumberfirst.value}-${phoneNumbersecond.value}-${phoneNumberthird.value}`
        }
    }

    try {
    const res = await axios.post('http://192.168.67:8080/attendance/unlogin', data)
    console.log(res)
    alert(`${adate.value}, ${name.value} 학생 ${type.value} 요청 완료!`)
    router.push({ name: 'loginhome' })
  } catch (e) {
    console.log(e)
    alert('에러')
  }
}

</script>

<style lang="scss" scoped></style>