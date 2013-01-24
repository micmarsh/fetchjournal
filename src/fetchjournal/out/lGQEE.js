goog.provide('fetchjournal.text');
goog.require('cljs.core');
goog.require('clj_time.core');
goog.require('clj_time.local');
goog.require('clj_time.local');
goog.require('clj_time.core');
fetchjournal.text.date_tag = (function date_tag(){
var months = cljs.core.PersistentVector.fromArray(["jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"], true);
var now = clj_time.local.local_now.call(null);
return [cljs.core.str("#"),cljs.core.str(months.call(null,(clj_time.core.month.call(null,now) - 1))),cljs.core.str(clj_time.core.day.call(null,now))].join('');
});
fetchjournal.text.make_note = (function make_note(text){
return [cljs.core.str("#journal "),cljs.core.str(fetchjournal.text.date_tag.call(null)),cljs.core.str(" "),cljs.core.str(text)].join('');
});
