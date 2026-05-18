package com.yeseok.memo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/memos")
@RestController
public class MemoController {

   private final MemoRepository memoRepository;

   public MemoController(MemoRepository memoRepository) {
      this.memoRepository = memoRepository;
   }

   @GetMapping
   public List<Memo> getMemos () {
      return memoRepository.findAll();
   }

   @PostMapping
   public Memo post(@RequestBody MemoRequest request) {
      Memo memo = new Memo(request.content());
      return memoRepository.save(memo);
   }

   @PutMapping("/{id}")
   public Memo updateMemo (@PathVariable Long id, @RequestBody MemoRequest request) {

      Memo memo = memoRepository.findById(id).orElseThrow(()-> new RuntimeException("Memo not found: " + id));

      memo.setContent(request.content());
      return memoRepository.save(memo);

   }

   @DeleteMapping("/{id}")
   public void deleteMemo (@PathVariable Long id) {

     memoRepository.findById(id).orElseThrow(()-> new RuntimeException("Memo not found: " + id));
     memoRepository.deleteById(id);

   }


   public record MemoRequest (String content) {

   }

}
