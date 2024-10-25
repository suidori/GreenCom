<template>
  <div class="absolute max-md:hidden"><SideBar /></div>
  <div class="w-3/4 max-w-2xl p-8 mx-auto bg-white rounded shadow-md min-w-80 max-lg:w-1/2">
    <h1 class="mb-4 text-3xl font-bold text-center">GREENART COMPUTER ACADEMY</h1>
    <form @submit.prevent="joinuser">
      <!-- 아이디 입력 -->
      <div class="mb-4">
        <label for="userid" class="block mb-2 text-sm font-bold text-gray-700"
          >아이디
          <p class="inline text-red-500">*</p></label
        >
        <input
          type="text"
          id="userid"
          placeholder="아이디를 입력하세요"
          v-model="userid"
          class="w-3/4 px-3 py-2 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
        />
         <button
         @click="checkid"
         class="px-4 py-2 font-bold text-white bg-blue-500 rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline"
        type="button"
        >
        중복확인
         </button>
         <p v-if="!idAvailable" class="text-sm text-red-500">{{ idError }}</p>
         <p v-if="idAvailable" class="text-sm text-green-500">사용 가능한 아이디입니다.</p>
      </div>

      <!-- 입력 항목들 -->
      <div class="mb-4">
        <label for="password" class="block mb-2 text-sm font-bold text-gray-700"
          >비밀번호
          <p class="inline text-red-500">*</p>
        </label>
        <input
          type="password"
          id="password"
          placeholder="비밀번호를 입력하세요"
          v-model="password"
          class="w-full px-3 py-2 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
        />
      </div>
      <div class="mb-4">
        <label for="name" class="block mb-2 text-sm font-bold text-gray-700"
          >이름
          <p class="inline text-red-500">*</p>
        </label>
        <input
          type="text"
          id="name"
          placeholder="이름을 입력하세요"
          v-model="name"
          class="w-full px-3 py-2 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
        />
      </div>
      <div class="mb-4">
        <label for="phoneNumber" class="block mb-2 text-sm font-bold text-gray-700"
          >전화번호
          <p class="inline text-red-500">*</p>
        </label>
        <select id="items" name="items" class="border border-gray-500" v-model="phoneNumberfirst">
                        <option value="010" selected>010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="018">018</option>
                        <option value="019">019</option>
                    </select>
                    - <input @blur="checkphone" type="text" v-model="phoneNumbersecond" class="border border-gray-500">
                    - <input @blur="checkphone" type="text" v-model="phoneNumberthird" class="border border-gray-500">
        <p v-if="!phoneAvailable" class="text-sm text-red-500">{{ phoneError }}</p>
         <p v-if="phoneAvailable" class="text-sm text-green-500">사용 가능한 전화번호입니다.</p>
      </div>
      <div class="mb-4">
        <label for="email" class="block mb-2 text-sm font-bold text-gray-700">이메일</label>
        <input
          type="email"
          id="email"
          placeholder="[선택] email@naver.com"
          v-model="email"
          class="w-full px-3 py-2 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
        />
      </div>
      <div class="mb-6">
        <label for="role" class="block mb-2 text-sm font-bold text-gray-700">관리자 여부</label>
        <input type="radio" value="ROLE_STUDENT" name="role" id="role-1" v-model="role" checked />
        <label for="role-1" class="p-1 pr-3">학생</label>
        <input type="radio" value="ROLE_TEACHER" name="role" id="role-2" v-model="role" />
        <label for="role-2" class="p-1 pr-3">선생</label>
        <input type="radio" value="ROLE_MANAGER" name="role" id="role-3" v-model="role" />
        <label for="role-3" class="p-1 pr-3">매니저</label>
      </div>
      <button
        @click="joinuser"
        class="px-4 py-2 font-bold text-white bg-blue-500 rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline"
        type="button"
      >
        회원가입
      </button>
      <!-- :disabled="!IdAvailable"
      >
        회원가입 -->
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'
import SideBar from '@/component/SideBar.vue'

const router = useRouter()

const userid = ref('')
const password = ref('')
const name = ref('')
const email = ref('')
const phoneNumberfirst = ref('');
const phoneNumbersecond = ref('');
const phoneNumberthird = ref('');
const role = ref('')
// const lecture = ref('')

// // 중복 확인 상태
const idAvailable = ref(false) // 아이디가 사용 가능한지 여부
const idError = ref('') // 오류 메시지

const phoneAvailable = ref(false)
const phoneError = ref('')

const checkphone = async () => {
// 아이디가 비어있을 경우
if (!phoneNumbersecond.value || !phoneNumberthird.value) {
  phoneError.value = '전화번호를 입력해 주세요.'
    phoneAvailable.value = false
    return
  }

  const phoneNumber = `${phoneNumberfirst.value}-${phoneNumbersecond.value}-${phoneNumberthird.value}`;

  try {
    const phoneResponse = await axios.get(`http://192.168.67:8080/sign/checkphone?phoneNumber=${phoneNumber}`);
    console.log(phoneNumber);
    console.log(phoneResponse);

    if (phoneResponse.data == false) {
      phoneError.value = '이미 가입된 전화번호입니다.'
      phoneAvailable.value = false
    } else {
      phoneError.value = ''
      phoneAvailable.value = true
    }
  } catch (error) {
    console.log(error)
    phoneError.value = '전화번호 중복 확인에 실패했습니다.'
    phoneAvailable.value = false
  }  
}

const checkid = async () => {
  // 아이디가 비어있을 경우
  if (!userid.value) {
    idError.value = '아이디를 입력해 주세요.'
    idAvailable.value = false
    return
  }

  try {
    const idResponse = await axios.get(`http://192.168.67:8080/sign/checkid?userid=${userid.value}`);

    if (idResponse.data == false) {
      idError.value = '이미 사용 중인 아이디입니다.'
      idAvailable.value = false
    } else {
      idError.value = ''
      idAvailable.value = true
    }
  } catch (error) {
    console.log(error)
    idError.value = '아이디 중복 확인에 실패했습니다.'
    idAvailable.value = false
  }
}

const joinuser = async () => {
  const data = {
    userid: userid.value,
    password: password.value,
    name: name.value,
    email: (email.value) ? email.value : null,
    phoneNumber: `${phoneNumberfirst.value}-${phoneNumbersecond.value}-${phoneNumberthird.value}`,
    role: role.value
    // lecture: lecture.value
  }

  try {
    const res = await axios.post('http://192.168.67:8080/sign/signin', data)
    console.log(res)
    router.push({ name: 'loginview' })
  } catch (e) {
    console.log(e)
    alert('에러')
  }
}
</script>
