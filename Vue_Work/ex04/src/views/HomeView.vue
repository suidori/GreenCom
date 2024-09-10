<template>
  <div>
    <h1>HOME</h1>
    <table class="border border-fray-500 w-full">
      <tr>
        <th class="border-gray-500">idx</th>
        <th class="border-gray-500">name</th>
        <th class="border-gray-500">age</th>
        <th class="border-gray-500">password</th>
        <th class="border-gray-500">wdate</th>
      </tr>
      <tr v-for="user in list" v-bind:key="user.idx">
        <td class="border-gray-500">{{ user.idx }}</td>
        <td class="border-gray-500">{{ user.name }}</td>
        <td class="border-gray-500">{{ user.age }}</td>
        <td class="border-gray-500">{{ user.password }}</td>
        <td class="border-gray-500">{{ user.wdate }}</td>
      </tr>
    </table>
    <button @click="select" class="bg-yellow-200 p-3 m-3 hover:bg-yellow-100">불러오기</button>
  </div>
  <div>
    name =
    <input
      type="text"
      name=""
      id=""
      class="p-5 border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64 text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md hover:bg-yellow-200 hover:shadow-lg"
      v-model="name"
    /><br />
    age =
    <input
      type="text"
      name=""
      id=""
      class="p-5 border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64 text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md hover:bg-yellow-200 hover:shadow-lg"
      v-model="age"
    /><br />
    password =
    <input
      type="text"
      name=""
      id=""
      class="p-5 border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64 text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md hover:bg-yellow-200 hover:shadow-lg"
      v-model="password"
    /><br />
    email =
    <input
      type="text"
      name=""
      id=""
      class="p-5 border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64 text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md hover:bg-yellow-200 hover:shadow-lg"
      v-model="email"
    /><br />
    <button @click="insert" class="bg-yellow-200 p-3 m-3 hover:bg-yellow-100">저장하기</button>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const list = ref([])
    const name = ref('')
    const password = ref('')
    const age = ref('')
    const email = ref('')
    const select = () => {
      fetch(`http://localhost:8080/user/select`)
        .then((res) => {
          return res.json()
        })
        .then((result) => {
          list.value = result
        })
        .catch((e) => {
          console.log('예외가 발생했습니다.')
          console.log(e)
        })
    }

    const insert = () => {
      const data = {
        name: name.value,
        age: age.value,
        password: password.value,
        email: email.value
      }

      fetch('http://localhost:8080/user/insert', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      })
        .then((response) => response.text())
        .then((result) => {
          console.log('Insert successful:', result)
          select()
        })
        .catch((e) => {
          console.log('Insert failed:', e)
        })
    }
    return { list, select, insert, name, age, password, email }
  }
}
</script>

<style lang="scss" scoped></style>
