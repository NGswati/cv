.data


.text
.globl main
main:

li $v0, 5
syscall
move $t0, $v0
move $t1, $t0

loop:
sub $t1, $t1, 1
mul $t0, $t1
bne $t1, 0, loop

li $v0, 1
move $a0, $t0
syscall

li $v0, 10
syscall