<template>
    <div class="mt-4">
      <h1 class="text-center my-5
      ">휴가 요청</h1>
      <div class="card">
        <div class="">
          <table class="table">
            <thead class="">
              <tr class="">
                <th>번호</th>
                <th>작성자</th>
                <th>강의</th>
                <th>시작일</th>
                <th>종료일</th>
                <th>승인 상태</th>
                <th>다운로드</th>
                <th>행동</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(vacation, index) in vacationList" :key="index">
                <td>{{ vacation.idx }}</td>
                <td>{{ vacation.user }}</td>
                <td>{{ vacation.lecture }}</td>
                <td>{{ vacation.startdate }}</td>
                <td>{{ vacation.enddate }}</td>
                <td>
                  <span :class="vacation.accept === '허가됨' ? 'text-success' : 'text-danger'">
                    {{ vacation.accept }}
                  </span>
                </td>
                <td>
                  <a v-if="vacation.accept === '허가됨'" 
                     :href="`http://192.168.0.67:8080/vacation/download/hwp/${vacation.idx}`" 
                     class="btn btn-primary btn-sm" 
                     target="_blank">다운로드</a>
                  <span v-else>—</span>
                </td>
                <td>
                  <button v-if="vacation.accept == '대기중'" 
                          @click="handleApprove(vacation.idx)" 
                          class="bg-blue-600 rounded-md text-white hover:opacity-80 mx-1">
                    승인
                  </button>
                  <button v-if="vacation.accept == '대기중'" 
                          @click="handleDeny(vacation.idx)" 
                          class="bg-blue-600 rounded-md text-white hover:opacity-80">
                    거절
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
          <div v-if="totalElements === 0" class="alert alert-info text-center" role="alert">
            휴가 요청이 없습니다.
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const vacationList = ref([]);
  const totalElements = ref(0);
  
  const fetchVacations = async () => {
    try {
      const response = await axios.get('http://192.168.0.67:8080/vacation/manager');
      vacationList.value = response.data.list; 
      totalElements.value = response.data.totalElements;
    } catch (error) {
      console.error('휴가 요청을 가져오는 중 오류 발생:', error);
    }
  };
  
  const handleApprove = async (idx) => {
    try {
      await axios.post(`http://192.168.0.67:8080/vacation/accept/${idx}`);
      fetchVacations(); // 요청 승인 후 목록 새로고침
    } catch (error) {
      console.error('승인 중 오류 발생:', error);
    }
  };
  
  const handleDeny = async (idx) => {
    try {
      await axios.post(`http://192.168.0.67:8080/vacation/deny/${idx}`);
      fetchVacations(); // 요청 거절 후 목록 새로고침
    } catch (error) {
      console.error('거절 중 오류 발생:', error);
    }
  };
  
  onMounted(() => {
    fetchVacations();
  });
  </script>
  
  <style scoped>
  .table th {
    background-color: #007bff;
    color: white;
  }
  .table td {
    vertical-align: middle;
  }
  .text-success {
    font-weight: bold;
  }
  .text-danger {
    font-weight: bold;
  }
  </style>
  