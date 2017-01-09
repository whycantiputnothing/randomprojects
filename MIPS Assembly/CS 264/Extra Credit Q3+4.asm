			.data
array1:	.byte 'h','E','L','l','o'
space:		.asciiz " "
string2:	.space 100
newLine: 	.asciiz "\n"
prompt:		.asciiz "Enter a character (max 100): "
upper:		.asciiz "Smallest uppercase letter: "
lower:		.asciiz "Largest lowercase letter: "
			.globl main
			.text
main:	la $a0, prompt
		li $v0, 4
		syscall
		la $a0, string2
		li $a1, 100
		li $v0, 8
		syscall
		la $a0, upper
		li $v0, 4
		syscall
		la $a0, array1
		jal SL
		move $a0, $v0
		li $v0, 11
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		la $a0, lower
		li $v0, 4
		syscall
		move $a0, $v1
		li $v0, 11
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		
		la $a0, upper
		li $v0, 4
		syscall
		la $a0, string2
		jal SL
		move $a0, $v0
		li $v0, 11
		syscall
		la $a0, newLine
		li $v0, 4
		syscall
		la $a0, lower
		li $v0, 4
		syscall
		move $a0, $v1
		li $v0, 11
		syscall
		
		
		li $v0, 10
		syscall
		
		
SL:		move $t0, $a0
		li $s0, 90
		li $s1, 97
		li $s2, 65
		li $v0, 91
		li $v1, 96
		
uLoop:	lb $t1, ($a0)	
		beqz $t1, uOut
		addi $a0, $a0, 1
		ble $t1, $s0, uCheck
		b uLoop
		
uCheck:	bge $t1, $s2, uChek2
		b uLoop
		
uChek2:	blt $t1, $v0, uMove
		b uLoop

uMove:	move $v0, $t1
		b uLoop

uOut:	addi $t1, $v0, -91
		beqz $t1, uLegal
		
lLoop:	lb $t1, ($t0)
		beqz $t1, lOut
		addi $t0, $t0, 1
		bge $t1, $s1, lCheck
		b lLoop
		
lCheck:	bgt $t1, $v1, lMove
		b lLoop
		
lMove:	move $v1, $t1
		b uLoop
		
lOut:	addi $t1, $v1, -96
		beqz $t1, lLegal
		b retzz
		
lLegal:	li $v1, 0
		b retzz
		
uLegal:	li $v0, 0
		b lLoop
		
retzz:	jr $ra