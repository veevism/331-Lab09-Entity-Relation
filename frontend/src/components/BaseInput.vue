<template>
    <label v-if="label">{{ label }}</label>
    <input class="field" :placeholder="label" :value="modelValue"
        @input="emit('update:modelValue', ($event.target as HTMLInputElement)?.value)" v-bind="$attrs" />
</template>
  
<script setup lang="ts">
const emit = defineEmits(['update:modelValue'])
const props = defineProps({
    label: {
        type: String,
        default: ''
    },
    modelValue: {
        type: [String, Number],
        required: false,
        default: ''
    }
})
</script>