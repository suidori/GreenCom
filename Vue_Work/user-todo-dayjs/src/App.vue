<template>
  <div>
    <input v-model="idx" placeholder="PDF 파일 ID 입력" />
    <button @click="openPdfPreview">PDF 미리보기</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const idx = ref(''); // 사용자가 입력한 PDF 파일의 idx 값

const openPdfPreview = async () => {
  const pdfWindow = window.open('', '_blank'); // 새 창 열기

  try {
    // 서버에서 PDF 파일을 idx로 요청
    const response = await fetch(`http://192.168.0.67:8080/vacation/download/pdf/${idx.value}`);
    if (!response.ok) {
      throw new Error('PDF 파일을 불러오는 중 오류 발생');
    }

    const blob = await response.blob(); // Blob 객체로 변환
    const url = URL.createObjectURL(blob); // Blob을 URL로 변환

    pdfWindow.location.href = url; // 새 창에 PDF 파일을 띄움
  } catch (error) {
    console.error('PDF 미리보기 오류:', error);
    pdfWindow.close(); // 오류 발생 시 새 창 닫기
  }
};
</script>
