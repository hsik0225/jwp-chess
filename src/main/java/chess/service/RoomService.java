package chess.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chess.domain.board.BoardDto;
import chess.domain.chess.Chess;
import chess.domain.room.Room;
import chess.repository.ChessRepository;
import chess.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ChessRepository chessRepository;

    public RoomService(RoomRepository roomRepository, ChessRepository chessRepository) {
        this.roomRepository = roomRepository;
        this.chessRepository = chessRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public long findChessIdById(long roomId) {
        return roomRepository.findChessIdById(roomId);
    }

    public Chess findChessById(long chessId) {
        return chessRepository.findChessById(chessId);
    }

    @Transactional
    public long insert(Room room) {
        BoardDto boardDto = BoardDto.from(Chess.createWithEmptyBoard().start());
        return roomRepository.insert(room, boardDto);
    }
}
