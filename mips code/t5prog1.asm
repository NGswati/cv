.data
mem: .word 0, 0, 0, 0, 1, 2, 3, 4, 5, 0

.text
.globl main
main:
la $t0, mem

li $t4, 0 #count 
li $t1, 0 #sum

loop:
lw $t3, 0($t0)
add $t1, $t1, $t3
add $t0, 4
add $t4, 1
bne $t4,10,loop



li $v0, 1
move $a0, $t1
syscall

li $v0, 10
syscall

#for storing sw $t1, num