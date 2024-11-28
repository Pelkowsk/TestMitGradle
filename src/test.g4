/*****************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2018-2024 Model Driven Solutions, Inc.
 * Copyright (c) 2018 IncQuery Labs Ltd.
 * Copyright (c) 2019 Maplesoft (Waterloo Maple, Inc.)
 * Copyright (c) 2019 Mgnite Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 *
 * Contributors:
 *  Ed Seidewitz, MDS
 *  Zoltan Kiss, IncQuery
 *  Balazs Grill, IncQuery
 *  Hisashi Miyashita, Maplesoft/Mgnite
 *
 *****************************************************************************/

grammar test;



// Lexer-Regeln (Tokens)
IF: 'if';
ELSE: 'else';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
MOD: '%';
QUESTION: '?';
COLON: ':';
GT: '>';
LT: '<';
GE: '>=';
LE: '<=';
EQ: '==';
NEQ: '!=';
AND: 'and';
OR: 'or';
XOR: 'xor';
IMPLIES: 'implies';
NUMBER: [0-9]+;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t\r\n]+ -> skip;

// Parser-Regeln
expr: conditionalExpr;

conditionalExpr:
    nullCoalescingExpr
    | IF nullCoalescingExpr QUESTION ownedExprRef ELSE ownedExprRef
;

nullCoalescingExpr:
    impliesExpr ('??' impliesExpr)*
;

ownedExprRef:
    ID // Vereinfachte Regel, falls `OwnedExpressionReference` nur ein Identifier ist
;

impliesExpr:
    orExpr (IMPLIES orExpr)*
;

orExpr:
    xorExpr ((OR | '|') xorExpr)*
;

xorExpr:
    andExpr (XOR andExpr)*
;

andExpr:
    equalityExpr ((AND | '&') equalityExpr)*
;

equalityExpr:
    relationalExpr ((EQ | NEQ) relationalExpr)*
;

relationalExpr:
    additiveExpr ((LT | GT | LE | GE) additiveExpr)*
;

additiveExpr:
    multiplicativeExpr ((PLUS | MINUS) multiplicativeExpr)*
;

multiplicativeExpr:
    primaryExpr ((MUL | DIV | MOD) primaryExpr)*
;

primaryExpr:
    NUMBER
    | ID
    | '(' expr ')'
;