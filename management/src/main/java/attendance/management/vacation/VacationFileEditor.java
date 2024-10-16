package attendance.management.vacation;


import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.CellFinder;
import kr.dogfoot.hwplib.writer.HWPWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacationFileEditor {

    private final VacationRepository vacationRepository;

    public void newHWP(long idx) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("vacation.hwp");

        String[] content = new String[]{"훈련과정명", "훈련기간", "성명", "주민등록번호", "사유", "희망일자", "비상연락망"};
        String[] body = new String[7];

        Optional<Vacation> vacation = vacationRepository.findById(idx);
        vacation.ifPresentOrElse((vacation1 -> {
            body[0] = vacation1.getLecture().getTitle();
            body[1] = vacation1.getLecture().getStartDate() + " ~ " + vacation1.getLecture().getEndDate();
            body[2] = vacation1.getUser().getName();
            body[3] = vacation1.getPersonalNum();
            body[4] = vacation1.getReason();
            body[5] = vacation1.getDate();
            body[6] = vacation1.getPhonecall();
                }),
                () -> { new BizException(ErrorCode.REQUEST_NOT_FOUND);
                });

        for (int i = 0; i < 7; i++) {
            setCellTextByField(hwpFile, content[i], body[i]);
        }

        HWPWriter.toFile(hwpFile, LocalDate.now() + body[2] + "휴가신청서.hwp");

    }

    private static void setCellTextByField(HWPFile hwpFile, String fieldName, String fieldText) throws UnsupportedEncodingException {
        ArrayList<Cell> cellList = CellFinder.findAll(hwpFile, fieldName);
        for (Cell c : cellList) {
            Paragraph firstPara = c.getParagraphList().getParagraph(0);
            ParaText paraText = firstPara.getText();
            if (paraText == null) {
                firstPara.createText();
                paraText = firstPara.getText();
            }

            paraText.addString(fieldText);
        }
    }
}
