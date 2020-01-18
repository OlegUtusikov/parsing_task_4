grammar Grammar;

@header {
#include <string>
#include "./../../src/Grammar.hpp"
}

st returns [std::string startValue]: START NTERM_TOKEN SCOLON { $startValue = $NTERM_TOKEN.text; };

header returns [std::string headerValue]: HEADER_CODE { $headerValue = $HEADER_CODE.text.substr(2, $HEADER_CODE.text.size() - 4); };

lexicalRule returns [Terminal term, bool droped]: TERM_TOKEN COLON STRING { $droped = false; } (ARROW DROP { $droped = true; })?
    SCOLON { $term = Terminal($TERM_TOKEN.text, $STRING.text.substr(1, $STRING.text.size() - 2)); };

rules returns [NonTerminal nterm]:
    NTERM_TOKEN { $nterm = NonTerminal($NTERM_TOKEN.text); }
    (ATTR { $nterm.arguments = $ATTR.text.substr(1, $ATTR.text.size() - 2);} )?
    ( RETS ATTR { $nterm.returns = $ATTR.text.substr(1, $ATTR.text.size() - 2); })?
    COLON
    ( ruleRight { $nterm.addRule(std::move($ruleRight.rule)); }
    ( STICK ruleRight { $nterm.addRule(std::move($ruleRight.rule)); })* ) SCOLON;

ruleRight returns [Rule rule] :
    (TERM_TOKEN {$rule.emplace_back($TERM_TOKEN.text);}
        | NTERM_TOKEN { $rule.emplace_back($NTERM_TOKEN.text); } (ATTR { $rule.back().code = $ATTR.text.substr(1, $ATTR.text.size() - 2); })? )
    (TERM_TOKEN { $rule.emplace_back($TERM_TOKEN.text); }
        | NTERM_TOKEN {$rule.emplace_back($NTERM_TOKEN.text);} (ATTR {$rule.back().code = $ATTR.text.substr(1, $ATTR.text.size() - 2);} )?
        | CODE {$rule.emplace_back("CODE", $CODE.text.substr(1, $CODE.text.size() - 2));})*
    | EPS {$rule.emplace_back("EPS");} (CODE {$rule.emplace_back("CODE", $CODE.text.substr(1, $CODE.text.size() - 2));})*;

gram returns [Grammar g]: (header { $g.setHeader($header.headerValue); })? st { $g.setStart($st.startValue); }
    ( lexicalRule { $g.addTerminal($lexicalRule.term, $lexicalRule.droped); } | rules { $g.addNonTerminal(std::move($rules.nterm));} )+;

DROP : 'drop';
RETS : 'returns';
START : 'start';
EPS : 'EPS';
ARROW : '->';

TERM_TOKEN : [A-Z]+;
NTERM_TOKEN : [a-z]+;
WHITESPACE : [ \t\r\n]+ -> skip;

CODE : LB .*? RB;
HEADER_CODE : PROCENT CODE PROCENT;
STRING : ('"' .*? '"' | '\'' .*? '\'');
ATTR : LSQUARE .*? RSQUARE;

LB      : '{';
RB      : '}';
LP      : '(';
RP      : ')';
LSQUARE : '[';
RSQUARE : ']';

COLON  : ':';
SCOLON : ';';
STICK  : '|';
PROCENT : '%';