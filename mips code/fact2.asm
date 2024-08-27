.data
msg1: .word "enter a num"
msg2: .word "the fact is"

.text
.globl main
main:

li $v0, 4
la $a0, msg1
syscall

li $v0, 5
syscall
move $t0,$v0

li $t1,1
li $t2,1

loop:
mul $t2, $t1
add $t1, 1
ble $t1, $t0, loop

li $v0, 4
la $a0, msg2
syscall

li $v0,1
move $a0, $t2
syscall

li $v0, 10
syscall