
.data
mem: .word 15, 14, 0

.text
.globl main
main:

la $t0, mem
lw $t1, 0($t0)
lw $t2, 4($t0)
add $t1, $t1, $t2
sw $t1,8($t0)

li $v0, 1
move $a0, $t1
syscall

li $v0, 10
syscall