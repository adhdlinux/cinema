package org.jsoup.parser;

import java.util.Arrays;
import org.jsoup.parser.Token;

enum TokeniserState {
    Data {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char q2 = characterReader.q();
            if (q2 == 0) {
                tokeniser.r(this);
                tokeniser.i(characterReader.d());
            } else if (q2 == '&') {
                tokeniser.a(TokeniserState.CharacterReferenceInData);
            } else if (q2 == '<') {
                tokeniser.a(TokeniserState.TagOpen);
            } else if (q2 != 65535) {
                tokeniser.j(characterReader.e());
            } else {
                tokeniser.k(new Token.EOF());
            }
        }
    },
    CharacterReferenceInData {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.n(tokeniser, TokeniserState.Data);
        }
    },
    Rcdata {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char q2 = characterReader.q();
            if (q2 == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i(65533);
            } else if (q2 == '&') {
                tokeniser.a(TokeniserState.CharacterReferenceInRcdata);
            } else if (q2 == '<') {
                tokeniser.a(TokeniserState.RcdataLessthanSign);
            } else if (q2 != 65535) {
                tokeniser.j(characterReader.m('&', '<', 0));
            } else {
                tokeniser.k(new Token.EOF());
            }
        }
    },
    CharacterReferenceInRcdata {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.n(tokeniser, TokeniserState.Rcdata);
        }
    },
    Rawtext {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.o(tokeniser, characterReader, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.o(tokeniser, characterReader, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char q2 = characterReader.q();
            if (q2 == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i(65533);
            } else if (q2 != 65535) {
                tokeniser.j(characterReader.k(0));
            } else {
                tokeniser.k(new Token.EOF());
            }
        }
    },
    TagOpen {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char q2 = characterReader.q();
            if (q2 == '!') {
                tokeniser.a(TokeniserState.MarkupDeclarationOpen);
            } else if (q2 == '/') {
                tokeniser.a(TokeniserState.EndTagOpen);
            } else if (q2 == '?') {
                tokeniser.a(TokeniserState.BogusComment);
            } else if (characterReader.B()) {
                tokeniser.g(true);
                tokeniser.u(TokeniserState.TagName);
            } else {
                tokeniser.r(this);
                tokeniser.i('<');
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    EndTagOpen {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.j("</");
                tokeniser.u(TokeniserState.Data);
            } else if (characterReader.B()) {
                tokeniser.g(false);
                tokeniser.u(TokeniserState.TagName);
            } else if (characterReader.v('>')) {
                tokeniser.r(this);
                tokeniser.a(TokeniserState.Data);
            } else {
                tokeniser.r(this);
                tokeniser.a(TokeniserState.BogusComment);
            }
        }
    },
    TagName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.f41737i.u(characterReader.j());
            char d2 = characterReader.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (d2 == '/') {
                        tokeniser.u(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (d2 == '>') {
                        tokeniser.o();
                        tokeniser.u(TokeniserState.Data);
                        return;
                    } else if (d2 == 65535) {
                        tokeniser.p(this);
                        tokeniser.u(TokeniserState.Data);
                        return;
                    } else if (!(d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13)) {
                        return;
                    }
                }
                tokeniser.u(TokeniserState.BeforeAttributeName);
                return;
            }
            tokeniser.f41737i.u(TokeniserState.f41786u0);
        }
    },
    RcdataLessthanSign {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('/')) {
                tokeniser.h();
                tokeniser.a(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (characterReader.B() && tokeniser.b() != null) {
                if (!characterReader.p("</" + tokeniser.b())) {
                    tokeniser.f41737i = tokeniser.g(false).A(tokeniser.b());
                    tokeniser.o();
                    characterReader.H();
                    tokeniser.u(TokeniserState.Data);
                    return;
                }
            }
            tokeniser.j("<");
            tokeniser.u(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagOpen {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                tokeniser.g(false);
                tokeniser.f41737i.t(characterReader.q());
                tokeniser.f41736h.append(characterReader.q());
                tokeniser.a(TokeniserState.RCDATAEndTagName);
                return;
            }
            tokeniser.j("</");
            tokeniser.u(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagName {
        private void q(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.j("</" + tokeniser.f41736h.toString());
            characterReader.H();
            tokeniser.u(TokeniserState.Rcdata);
        }

        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                String h2 = characterReader.h();
                tokeniser.f41737i.u(h2);
                tokeniser.f41736h.append(h2);
                return;
            }
            char d2 = characterReader.d();
            if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ') {
                if (tokeniser.s()) {
                    tokeniser.u(TokeniserState.BeforeAttributeName);
                } else {
                    q(tokeniser, characterReader);
                }
            } else if (d2 != '/') {
                if (d2 != '>') {
                    q(tokeniser, characterReader);
                } else if (tokeniser.s()) {
                    tokeniser.o();
                    tokeniser.u(TokeniserState.Data);
                } else {
                    q(tokeniser, characterReader);
                }
            } else if (tokeniser.s()) {
                tokeniser.u(TokeniserState.SelfClosingStartTag);
            } else {
                q(tokeniser, characterReader);
            }
        }
    },
    RawtextLessthanSign {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('/')) {
                tokeniser.h();
                tokeniser.a(TokeniserState.RawtextEndTagOpen);
                return;
            }
            tokeniser.i('<');
            tokeniser.u(TokeniserState.Rawtext);
        }
    },
    RawtextEndTagOpen {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.p(tokeniser, characterReader, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.l(tokeniser, characterReader, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == '!') {
                tokeniser.j("<!");
                tokeniser.u(TokeniserState.ScriptDataEscapeStart);
            } else if (d2 != '/') {
                tokeniser.j("<");
                characterReader.H();
                tokeniser.u(TokeniserState.ScriptData);
            } else {
                tokeniser.h();
                tokeniser.u(TokeniserState.ScriptDataEndTagOpen);
            }
        }
    },
    ScriptDataEndTagOpen {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.p(tokeniser, characterReader, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.l(tokeniser, characterReader, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('-')) {
                tokeniser.i('-');
                tokeniser.a(TokeniserState.ScriptDataEscapeStartDash);
                return;
            }
            tokeniser.u(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStartDash {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('-')) {
                tokeniser.i('-');
                tokeniser.a(TokeniserState.ScriptDataEscapedDashDash);
                return;
            }
            tokeniser.u(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscaped {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
                return;
            }
            char q2 = characterReader.q();
            if (q2 == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i(65533);
            } else if (q2 == '-') {
                tokeniser.i('-');
                tokeniser.a(TokeniserState.ScriptDataEscapedDash);
            } else if (q2 != '<') {
                tokeniser.j(characterReader.m('-', '<', 0));
            } else {
                tokeniser.a(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
                return;
            }
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.i(65533);
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            } else if (d2 == '-') {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataEscapedDashDash);
            } else if (d2 != '<') {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            } else {
                tokeniser.u(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDashDash {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
                return;
            }
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.i(65533);
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            } else if (d2 == '-') {
                tokeniser.i(d2);
            } else if (d2 == '<') {
                tokeniser.u(TokeniserState.ScriptDataEscapedLessthanSign);
            } else if (d2 != '>') {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            } else {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptData);
            }
        }
    },
    ScriptDataEscapedLessthanSign {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                tokeniser.h();
                tokeniser.f41736h.append(characterReader.q());
                tokeniser.j("<" + characterReader.q());
                tokeniser.a(TokeniserState.ScriptDataDoubleEscapeStart);
            } else if (characterReader.v('/')) {
                tokeniser.h();
                tokeniser.a(TokeniserState.ScriptDataEscapedEndTagOpen);
            } else {
                tokeniser.i('<');
                tokeniser.u(TokeniserState.ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedEndTagOpen {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                tokeniser.g(false);
                tokeniser.f41737i.t(characterReader.q());
                tokeniser.f41736h.append(characterReader.q());
                tokeniser.a(TokeniserState.ScriptDataEscapedEndTagName);
                return;
            }
            tokeniser.j("</");
            tokeniser.u(TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.l(tokeniser, characterReader, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.k(tokeniser, characterReader, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char q2 = characterReader.q();
            if (q2 == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.i(65533);
            } else if (q2 == '-') {
                tokeniser.i(q2);
                tokeniser.a(TokeniserState.ScriptDataDoubleEscapedDash);
            } else if (q2 == '<') {
                tokeniser.i(q2);
                tokeniser.a(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (q2 != 65535) {
                tokeniser.j(characterReader.m('-', '<', 0));
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.i(65533);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
            } else if (d2 == '-') {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscapedDashDash);
            } else if (d2 == '<') {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (d2 != 65535) {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.i(65533);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
            } else if (d2 == '-') {
                tokeniser.i(d2);
            } else if (d2 == '<') {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (d2 == '>') {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptData);
            } else if (d2 != 65535) {
                tokeniser.i(d2);
                tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('/')) {
                tokeniser.i('/');
                tokeniser.h();
                tokeniser.a(TokeniserState.ScriptDataDoubleEscapeEnd);
                return;
            }
            tokeniser.u(TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.k(tokeniser, characterReader, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41737i.B();
                characterReader.H();
                tokeniser.u(TokeniserState.AttributeName);
            } else if (d2 != ' ') {
                if (!(d2 == '\"' || d2 == '\'')) {
                    if (d2 == '/') {
                        tokeniser.u(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (d2 == 65535) {
                        tokeniser.p(this);
                        tokeniser.u(TokeniserState.Data);
                        return;
                    } else if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13) {
                        switch (d2) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                tokeniser.o();
                                tokeniser.u(TokeniserState.Data);
                                return;
                            default:
                                tokeniser.f41737i.B();
                                characterReader.H();
                                tokeniser.u(TokeniserState.AttributeName);
                                return;
                        }
                    } else {
                        return;
                    }
                }
                tokeniser.r(this);
                tokeniser.f41737i.B();
                tokeniser.f41737i.o(d2);
                tokeniser.u(TokeniserState.AttributeName);
            }
        }
    },
    AttributeName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.f41737i.p(characterReader.n(TokeniserState.f41782s0));
            char d2 = characterReader.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (!(d2 == '\"' || d2 == '\'')) {
                        if (d2 == '/') {
                            tokeniser.u(TokeniserState.SelfClosingStartTag);
                            return;
                        } else if (d2 == 65535) {
                            tokeniser.p(this);
                            tokeniser.u(TokeniserState.Data);
                            return;
                        } else if (!(d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13)) {
                            switch (d2) {
                                case '<':
                                    break;
                                case '=':
                                    tokeniser.u(TokeniserState.BeforeAttributeValue);
                                    return;
                                case '>':
                                    tokeniser.o();
                                    tokeniser.u(TokeniserState.Data);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                    tokeniser.r(this);
                    tokeniser.f41737i.o(d2);
                    return;
                }
                tokeniser.u(TokeniserState.AfterAttributeName);
                return;
            }
            tokeniser.r(this);
            tokeniser.f41737i.o(65533);
        }
    },
    AfterAttributeName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41737i.o(65533);
                tokeniser.u(TokeniserState.AttributeName);
            } else if (d2 != ' ') {
                if (!(d2 == '\"' || d2 == '\'')) {
                    if (d2 == '/') {
                        tokeniser.u(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (d2 == 65535) {
                        tokeniser.p(this);
                        tokeniser.u(TokeniserState.Data);
                        return;
                    } else if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13) {
                        switch (d2) {
                            case '<':
                                break;
                            case '=':
                                tokeniser.u(TokeniserState.BeforeAttributeValue);
                                return;
                            case '>':
                                tokeniser.o();
                                tokeniser.u(TokeniserState.Data);
                                return;
                            default:
                                tokeniser.f41737i.B();
                                characterReader.H();
                                tokeniser.u(TokeniserState.AttributeName);
                                return;
                        }
                    } else {
                        return;
                    }
                }
                tokeniser.r(this);
                tokeniser.f41737i.B();
                tokeniser.f41737i.o(d2);
                tokeniser.u(TokeniserState.AttributeName);
            }
        }
    },
    BeforeAttributeValue {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41737i.q(65533);
                tokeniser.u(TokeniserState.AttributeValue_unquoted);
            } else if (d2 == ' ') {
            } else {
                if (d2 != '\"') {
                    if (d2 != '`') {
                        if (d2 == 65535) {
                            tokeniser.p(this);
                            tokeniser.o();
                            tokeniser.u(TokeniserState.Data);
                            return;
                        } else if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13) {
                            if (d2 == '&') {
                                characterReader.H();
                                tokeniser.u(TokeniserState.AttributeValue_unquoted);
                                return;
                            } else if (d2 != '\'') {
                                switch (d2) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.r(this);
                                        tokeniser.o();
                                        tokeniser.u(TokeniserState.Data);
                                        return;
                                    default:
                                        characterReader.H();
                                        tokeniser.u(TokeniserState.AttributeValue_unquoted);
                                        return;
                                }
                            } else {
                                tokeniser.u(TokeniserState.AttributeValue_singleQuoted);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    tokeniser.r(this);
                    tokeniser.f41737i.q(d2);
                    tokeniser.u(TokeniserState.AttributeValue_unquoted);
                    return;
                }
                tokeniser.u(TokeniserState.AttributeValue_doubleQuoted);
            }
        }
    },
    AttributeValue_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            String m2 = characterReader.m(TokeniserState.f41780r0);
            if (m2.length() > 0) {
                tokeniser.f41737i.r(m2);
            } else {
                tokeniser.f41737i.E();
            }
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41737i.q(65533);
            } else if (d2 == '\"') {
                tokeniser.u(TokeniserState.AfterAttributeValue_quoted);
            } else if (d2 == '&') {
                int[] d3 = tokeniser.d('\"', true);
                if (d3 != null) {
                    tokeniser.f41737i.s(d3);
                } else {
                    tokeniser.f41737i.q('&');
                }
            } else if (d2 == 65535) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    AttributeValue_singleQuoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            String m2 = characterReader.m(TokeniserState.f41778q0);
            if (m2.length() > 0) {
                tokeniser.f41737i.r(m2);
            } else {
                tokeniser.f41737i.E();
            }
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41737i.q(65533);
            } else if (d2 == 65535) {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            } else if (d2 == '&') {
                int[] d3 = tokeniser.d('\'', true);
                if (d3 != null) {
                    tokeniser.f41737i.s(d3);
                } else {
                    tokeniser.f41737i.q('&');
                }
            } else if (d2 == '\'') {
                tokeniser.u(TokeniserState.AfterAttributeValue_quoted);
            }
        }
    },
    AttributeValue_unquoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            String n2 = characterReader.n(TokeniserState.f41784t0);
            if (n2.length() > 0) {
                tokeniser.f41737i.r(n2);
            }
            char d2 = characterReader.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (!(d2 == '\"' || d2 == '`')) {
                        if (d2 == 65535) {
                            tokeniser.p(this);
                            tokeniser.u(TokeniserState.Data);
                            return;
                        } else if (!(d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13)) {
                            if (d2 == '&') {
                                int[] d3 = tokeniser.d('>', true);
                                if (d3 != null) {
                                    tokeniser.f41737i.s(d3);
                                    return;
                                } else {
                                    tokeniser.f41737i.q('&');
                                    return;
                                }
                            } else if (d2 != '\'') {
                                switch (d2) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.o();
                                        tokeniser.u(TokeniserState.Data);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    }
                    tokeniser.r(this);
                    tokeniser.f41737i.q(d2);
                    return;
                }
                tokeniser.u(TokeniserState.BeforeAttributeName);
                return;
            }
            tokeniser.r(this);
            tokeniser.f41737i.q(65533);
        }
    },
    AfterAttributeValue_quoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ') {
                tokeniser.u(TokeniserState.BeforeAttributeName);
            } else if (d2 == '/') {
                tokeniser.u(TokeniserState.SelfClosingStartTag);
            } else if (d2 == '>') {
                tokeniser.o();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.r(this);
                characterReader.H();
                tokeniser.u(TokeniserState.BeforeAttributeName);
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    SelfClosingStartTag {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == '>') {
                tokeniser.f41737i.f41717i = true;
                tokeniser.o();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.r(this);
                characterReader.H();
                tokeniser.u(TokeniserState.BeforeAttributeName);
            } else {
                tokeniser.p(this);
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BogusComment {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.H();
            Token.Comment comment = new Token.Comment();
            comment.f41704c = true;
            comment.f41703b.append(characterReader.k('>'));
            tokeniser.k(comment);
            tokeniser.a(TokeniserState.Data);
        }
    },
    MarkupDeclarationOpen {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.t("--")) {
                tokeniser.e();
                tokeniser.u(TokeniserState.CommentStart);
            } else if (characterReader.u("DOCTYPE")) {
                tokeniser.u(TokeniserState.Doctype);
            } else if (characterReader.t("[CDATA[")) {
                tokeniser.u(TokeniserState.CdataSection);
            } else {
                tokeniser.r(this);
                tokeniser.a(TokeniserState.BogusComment);
            }
        }
    },
    CommentStart {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41742n.f41703b.append(65533);
                tokeniser.u(TokeniserState.Comment);
            } else if (d2 == '-') {
                tokeniser.u(TokeniserState.CommentStartDash);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.f41742n.f41703b.append(d2);
                tokeniser.u(TokeniserState.Comment);
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CommentStartDash {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41742n.f41703b.append(65533);
                tokeniser.u(TokeniserState.Comment);
            } else if (d2 == '-') {
                tokeniser.u(TokeniserState.CommentStartDash);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.f41742n.f41703b.append(d2);
                tokeniser.u(TokeniserState.Comment);
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    Comment {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char q2 = characterReader.q();
            if (q2 == 0) {
                tokeniser.r(this);
                characterReader.a();
                tokeniser.f41742n.f41703b.append(65533);
            } else if (q2 == '-') {
                tokeniser.a(TokeniserState.CommentEndDash);
            } else if (q2 != 65535) {
                tokeniser.f41742n.f41703b.append(characterReader.m('-', 0));
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CommentEndDash {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                StringBuilder sb = tokeniser.f41742n.f41703b;
                sb.append('-');
                sb.append(65533);
                tokeniser.u(TokeniserState.Comment);
            } else if (d2 == '-') {
                tokeniser.u(TokeniserState.CommentEnd);
            } else if (d2 != 65535) {
                StringBuilder sb2 = tokeniser.f41742n.f41703b;
                sb2.append('-');
                sb2.append(d2);
                tokeniser.u(TokeniserState.Comment);
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CommentEnd {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                StringBuilder sb = tokeniser.f41742n.f41703b;
                sb.append("--");
                sb.append(65533);
                tokeniser.u(TokeniserState.Comment);
            } else if (d2 == '!') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.CommentEndBang);
            } else if (d2 == '-') {
                tokeniser.r(this);
                tokeniser.f41742n.f41703b.append('-');
            } else if (d2 == '>') {
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.r(this);
                StringBuilder sb2 = tokeniser.f41742n.f41703b;
                sb2.append("--");
                sb2.append(d2);
                tokeniser.u(TokeniserState.Comment);
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CommentEndBang {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                StringBuilder sb = tokeniser.f41742n.f41703b;
                sb.append("--!");
                sb.append(65533);
                tokeniser.u(TokeniserState.Comment);
            } else if (d2 == '-') {
                tokeniser.f41742n.f41703b.append("--!");
                tokeniser.u(TokeniserState.CommentEndDash);
            } else if (d2 == '>') {
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                StringBuilder sb2 = tokeniser.f41742n.f41703b;
                sb2.append("--!");
                sb2.append(d2);
                tokeniser.u(TokeniserState.Comment);
            } else {
                tokeniser.p(this);
                tokeniser.m();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    Doctype {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ') {
                tokeniser.u(TokeniserState.BeforeDoctypeName);
                return;
            }
            if (d2 != '>') {
                if (d2 != 65535) {
                    tokeniser.r(this);
                    tokeniser.u(TokeniserState.BeforeDoctypeName);
                    return;
                }
                tokeniser.p(this);
            }
            tokeniser.r(this);
            tokeniser.f();
            tokeniser.f41741m.f41709f = true;
            tokeniser.n();
            tokeniser.u(TokeniserState.Data);
        }
    },
    BeforeDoctypeName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                tokeniser.f();
                tokeniser.u(TokeniserState.DoctypeName);
                return;
            }
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f();
                tokeniser.f41741m.f41705b.append(65533);
                tokeniser.u(TokeniserState.DoctypeName);
            } else if (d2 == ' ') {
            } else {
                if (d2 == 65535) {
                    tokeniser.p(this);
                    tokeniser.f();
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                } else if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13) {
                    tokeniser.f();
                    tokeniser.f41741m.f41705b.append(d2);
                    tokeniser.u(TokeniserState.DoctypeName);
                }
            }
        }
    },
    DoctypeName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                tokeniser.f41741m.f41705b.append(characterReader.h());
                return;
            }
            char d2 = characterReader.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (d2 == '>') {
                        tokeniser.n();
                        tokeniser.u(TokeniserState.Data);
                        return;
                    } else if (d2 == 65535) {
                        tokeniser.p(this);
                        tokeniser.f41741m.f41709f = true;
                        tokeniser.n();
                        tokeniser.u(TokeniserState.Data);
                        return;
                    } else if (!(d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13)) {
                        tokeniser.f41741m.f41705b.append(d2);
                        return;
                    }
                }
                tokeniser.u(TokeniserState.AfterDoctypeName);
                return;
            }
            tokeniser.r(this);
            tokeniser.f41741m.f41705b.append(65533);
        }
    },
    AfterDoctypeName {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.r()) {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (characterReader.x(9, 10, 13, 12, ' ')) {
                characterReader.a();
            } else if (characterReader.v('>')) {
                tokeniser.n();
                tokeniser.a(TokeniserState.Data);
            } else if (characterReader.u("PUBLIC")) {
                tokeniser.f41741m.f41706c = "PUBLIC";
                tokeniser.u(TokeniserState.AfterDoctypePublicKeyword);
            } else if (characterReader.u("SYSTEM")) {
                tokeniser.f41741m.f41706c = "SYSTEM";
                tokeniser.u(TokeniserState.AfterDoctypeSystemKeyword);
            } else {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.a(TokeniserState.BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ') {
                tokeniser.u(TokeniserState.BeforeDoctypePublicIdentifier);
            } else if (d2 == '\"') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
            } else if (d2 == '\'') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypePublicIdentifier {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13 && d2 != ' ') {
                if (d2 == '\"') {
                    tokeniser.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                } else if (d2 == '\'') {
                    tokeniser.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                } else if (d2 == '>') {
                    tokeniser.r(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                } else if (d2 != 65535) {
                    tokeniser.r(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.u(TokeniserState.BogusDoctype);
                } else {
                    tokeniser.p(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                }
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41741m.f41707d.append(65533);
            } else if (d2 == '\"') {
                tokeniser.u(TokeniserState.AfterDoctypePublicIdentifier);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.f41741m.f41707d.append(d2);
            } else {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_singleQuoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41741m.f41707d.append(65533);
            } else if (d2 == '\'') {
                tokeniser.u(TokeniserState.AfterDoctypePublicIdentifier);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.f41741m.f41707d.append(d2);
            } else {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    AfterDoctypePublicIdentifier {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ') {
                tokeniser.u(TokeniserState.BetweenDoctypePublicAndSystemIdentifiers);
            } else if (d2 == '\"') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (d2 == '\'') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (d2 == '>') {
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.u(TokeniserState.BogusDoctype);
            } else {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13 && d2 != ' ') {
                if (d2 == '\"') {
                    tokeniser.r(this);
                    tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                } else if (d2 == '\'') {
                    tokeniser.r(this);
                    tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                } else if (d2 == '>') {
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                } else if (d2 != 65535) {
                    tokeniser.r(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.u(TokeniserState.BogusDoctype);
                } else {
                    tokeniser.p(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                }
            }
        }
    },
    AfterDoctypeSystemKeyword {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ') {
                tokeniser.u(TokeniserState.BeforeDoctypeSystemIdentifier);
            } else if (d2 == '\"') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (d2 == '\'') {
                tokeniser.r(this);
                tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
            } else {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypeSystemIdentifier {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13 && d2 != ' ') {
                if (d2 == '\"') {
                    tokeniser.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                } else if (d2 == '\'') {
                    tokeniser.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                } else if (d2 == '>') {
                    tokeniser.r(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                } else if (d2 != 65535) {
                    tokeniser.r(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.u(TokeniserState.BogusDoctype);
                } else {
                    tokeniser.p(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                }
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41741m.f41708e.append(65533);
            } else if (d2 == '\"') {
                tokeniser.u(TokeniserState.AfterDoctypeSystemIdentifier);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.f41741m.f41708e.append(d2);
            } else {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_singleQuoted {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == 0) {
                tokeniser.r(this);
                tokeniser.f41741m.f41708e.append(65533);
            } else if (d2 == '\'') {
                tokeniser.u(TokeniserState.AfterDoctypeSystemIdentifier);
            } else if (d2 == '>') {
                tokeniser.r(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 != 65535) {
                tokeniser.f41741m.f41708e.append(d2);
            } else {
                tokeniser.p(this);
                tokeniser.f41741m.f41709f = true;
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemIdentifier {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 != 9 && d2 != 10 && d2 != 12 && d2 != 13 && d2 != ' ') {
                if (d2 == '>') {
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                } else if (d2 != 65535) {
                    tokeniser.r(this);
                    tokeniser.u(TokeniserState.BogusDoctype);
                } else {
                    tokeniser.p(this);
                    tokeniser.f41741m.f41709f = true;
                    tokeniser.n();
                    tokeniser.u(TokeniserState.Data);
                }
            }
        }
    },
    BogusDoctype {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            char d2 = characterReader.d();
            if (d2 == '>') {
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            } else if (d2 == 65535) {
                tokeniser.n();
                tokeniser.u(TokeniserState.Data);
            }
        }
    },
    CdataSection {
        /* access modifiers changed from: package-private */
        public void m(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.j(characterReader.l("]]>"));
            characterReader.t("]]>");
            tokeniser.u(TokeniserState.Data);
        }
    };
    
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public static final char[] f41778q0 = null;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public static final char[] f41780r0 = null;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public static final char[] f41782s0 = null;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public static final char[] f41784t0 = null;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public static final String f41786u0 = null;

    static {
        char[] cArr = {'\'', '&', 0};
        f41778q0 = cArr;
        char[] cArr2 = {'\"', '&', 0};
        f41780r0 = cArr2;
        char[] cArr3 = {9, 10, 13, 12, ' ', '/', '=', '>', 0, '\"', '\'', '<'};
        f41782s0 = cArr3;
        char[] cArr4 = {9, 10, 13, 12, ' ', '&', '>', 0, '\"', '\'', '<', '=', '`'};
        f41784t0 = cArr4;
        f41786u0 = String.valueOf(65533);
        Arrays.sort(cArr);
        Arrays.sort(cArr2);
        Arrays.sort(cArr3);
        Arrays.sort(cArr4);
    }

    /* access modifiers changed from: private */
    public static void k(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.B()) {
            String h2 = characterReader.h();
            tokeniser.f41736h.append(h2);
            tokeniser.j(h2);
            return;
        }
        char d2 = characterReader.d();
        if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ' || d2 == '/' || d2 == '>') {
            if (tokeniser.f41736h.toString().equals("script")) {
                tokeniser.u(tokeniserState);
            } else {
                tokeniser.u(tokeniserState2);
            }
            tokeniser.i(d2);
            return;
        }
        characterReader.H();
        tokeniser.u(tokeniserState2);
    }

    /* access modifiers changed from: private */
    public static void l(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.B()) {
            String h2 = characterReader.h();
            tokeniser.f41737i.u(h2);
            tokeniser.f41736h.append(h2);
            return;
        }
        boolean z2 = true;
        if (tokeniser.s() && !characterReader.r()) {
            char d2 = characterReader.d();
            if (d2 == 9 || d2 == 10 || d2 == 12 || d2 == 13 || d2 == ' ') {
                tokeniser.u(BeforeAttributeName);
            } else if (d2 == '/') {
                tokeniser.u(SelfClosingStartTag);
            } else if (d2 != '>') {
                tokeniser.f41736h.append(d2);
            } else {
                tokeniser.o();
                tokeniser.u(Data);
            }
            z2 = false;
        }
        if (z2) {
            tokeniser.j("</" + tokeniser.f41736h.toString());
            tokeniser.u(tokeniserState);
        }
    }

    /* access modifiers changed from: private */
    public static void n(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] d2 = tokeniser.d((Character) null, false);
        if (d2 == null) {
            tokeniser.i('&');
        } else {
            tokeniser.l(d2);
        }
        tokeniser.u(tokeniserState);
    }

    /* access modifiers changed from: private */
    public static void o(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char q2 = characterReader.q();
        if (q2 == 0) {
            tokeniser.r(tokeniserState);
            characterReader.a();
            tokeniser.i(65533);
        } else if (q2 == '<') {
            tokeniser.a(tokeniserState2);
        } else if (q2 != 65535) {
            tokeniser.j(characterReader.m('<', 0));
        } else {
            tokeniser.k(new Token.EOF());
        }
    }

    /* access modifiers changed from: private */
    public static void p(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.B()) {
            tokeniser.g(false);
            tokeniser.u(tokeniserState);
            return;
        }
        tokeniser.j("</");
        tokeniser.u(tokeniserState2);
    }

    /* access modifiers changed from: package-private */
    public abstract void m(Tokeniser tokeniser, CharacterReader characterReader);
}
