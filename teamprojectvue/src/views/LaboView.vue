<template>
    <!-- 드랍박스 여기 -->
  <div class="px-52">
    <DropBox />
    <label for="ex">라벨태그</label>
    <select name="ex" id="" class="border rounded-md p-1">
        <option value="opt1">옵션1</option>
        <option value="opt2" class="">옵션2</option>
        <option value="op3">옵션3</option>
    </select>
  </div>

  <div>
    <!-- component -->
    <div class="flex justify-center items-center min-h-screen">
      <div class="max-w-[720px] mx-auto">
        <div class="block mb-4 mx-auto border-b border-slate-300 pb-2 max-w-[360px]">
          <a
            target="_blank"
            href="https://www.material-tailwind.com/docs/html/input-phone"
            class="block w-full px-4 py-2 text-center text-slate-700 transition-all"
          >
            More components on <b>Material Tailwind</b>.
          </a>
        </div>

        <div class="w-full max-w-sm min-w-[200px] mt-4">
          <label class="block mb-1 text-sm text-slate-800"> Enter Phone Number </label>

          <div class="relative mt-2">
            <div class="absolute top-2 left-0 flex items-center pl-3">
              <button
                id="dropdownButton"
                class="h-full text-sm flex justify-center items-center bg-transparent text-slate-700 focus:outline-none"
              >
                <span id="dropdownSpan">+33</span>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke-width="1.5"
                  stroke="currentColor"
                  class="h-4 w-4 ml-1"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    d="m19.5 8.25-7.5 7.5-7.5-7.5"
                  />
                </svg>
              </button>

              <div class="h-6 border-l border-slate-200 ml-2"></div>
              <div
                id="dropdownMenu"
                class="min-w-[150px] overflow-hidden absolute left-0 w-full mt-10 hidden bg-white border border-slate-200 rounded-md shadow-lg z-10"
              >
                <ul id="dropdownOptions">
                  <li
                    class="px-4 py-2 text-slate-800 hover:bg-slate-100 text-sm cursor-pointer"
                    data-value="+33"
                  >
                    France (+33)
                  </li>
                  <li
                    class="px-4 py-2 text-slate-800 hover:bg-slate-100 text-sm cursor-pointer"
                    data-value="+49"
                  >
                    Germany (+49)
                  </li>
                  <li
                    class="px-4 py-2 text-slate-800 hover:bg-slate-100 text-sm cursor-pointer"
                    data-value="+34"
                  >
                    Spain (+34)
                  </li>
                  <li
                    class="px-4 py-2 text-slate-800 hover:bg-slate-100 text-sm cursor-pointer"
                    data-value="+1"
                  >
                    USA (+1)
                  </li>
                </ul>
              </div>
            </div>
            <input
              type="number"
              class="w-full h-10 pl-20 bg-transparent placeholder:text-slate-400 text-slate-700 text-sm border border-slate-200 rounded-md px-3 py-2 transition duration-300 ease focus:outline-none focus:border-slate-400 hover:border-slate-400 shadow-sm focus:shadow-md"
              placeholder="324-456-2323"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import DropBox from '@/component/DropBox.vue'
</script>

<style lang="scss" scoped></style>
