.data
num1: .word 15
num2: .word 14
sum: .word 0

.text
.globl main
main:

lw $t0,num1
lw $t1,num2
add $t1,$t1,$t0
sw $t1,sum
li $v0,1
move $a0,$t1
syscall

li $v0, 10
syscall